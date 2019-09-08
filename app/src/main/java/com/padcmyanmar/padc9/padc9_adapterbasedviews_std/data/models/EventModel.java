package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.models;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventVO;

import java.util.List;

public interface EventModel {

    void getEvents(GetEventsFromNetworkDelegate delegate);

    EventVO findEventById(int eventId);

    interface GetEventsFromNetworkDelegate{
        void onSuccess(List<EventVO> events);
        void onFailure(String errorMessage);
    }
}
