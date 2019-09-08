package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.dataagents;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventVO;

import java.util.List;

public interface EventsDataAgent {

    void getEvents(String access_token, GetEventsFromNetworkDelegate delegate);

    interface GetEventsFromNetworkDelegate{
        void onSuccess(List<EventVO> events);
        void onFailure(String errorMessage);
    }
}
