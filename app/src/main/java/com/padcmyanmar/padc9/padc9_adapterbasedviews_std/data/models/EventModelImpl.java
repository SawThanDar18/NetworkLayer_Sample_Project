package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.models;

import android.content.Context;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventVO;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.dataagents.EventsDataAgent;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.utils.EventsConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventModelImpl extends BaseModel implements EventModel {

    private Map<Integer, EventVO> eventsDataRepository;

    private static EventModelImpl objInstance;

    private EventModelImpl(Context context) {
        super(context);
        eventsDataRepository = new HashMap<>();
    }

    public static void initializeEventModel(Context context){
        objInstance = new EventModelImpl(context);
    }

    public static EventModelImpl getObjInstance() {
        if (objInstance == null) {
            throw new RuntimeException(EventsConstants.EM_EVENT_MODEL_NOT_INITIALIZED);
        }
        return objInstance;
    }

    @Override
    public void getEvents(final GetEventsFromNetworkDelegate delegate) {
        if (eventDatabase.areEventsExistInDB()){
            List<EventVO> eventsFromDB = eventDatabase.eventDao().getAllEvents();
            delegate.onSuccess(eventsFromDB);
        }else {
            mDataAgent.getEvents(EventsConstants.DUMMY_ACCESS_TOKEN, new EventsDataAgent.GetEventsFromNetworkDelegate() {
                @Override
                public void onSuccess(List<EventVO> events) {
                    /*for (EventVO eventVO : events){
                        eventsDataRepository.put(eventVO.getId(), eventVO);
                    }*/

                    //long[] ids = eventDatabase.eventDao().insertEvents(events);
                    eventDatabase.eventDao().insertEventsAndUsers(events, eventDatabase.userDao());
                    delegate.onSuccess(events);
                }

                @Override
                public void onFailure(String errorMessage) {
                    delegate.onFailure(errorMessage);
                }
            });
        }
    }

    @Override
    public EventVO findEventById(int eventId) {
        //EventVO eventVO = eventsDataRepository.get(eventId);   //fetch data from dataRepository
        EventVO eventVO = eventDatabase.eventDao().getEventById(eventId);  //fetch data from database
        return eventVO;
    }
}
