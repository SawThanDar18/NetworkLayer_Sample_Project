package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.responses;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.utils.EventsConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EventsApi {

    @FormUrlEncoded
    @POST(EventsConstants.GET_EVENTS)
    Call<GetEventsResponse> getAllEvents(@Field(EventsConstants.PARAM_ACCESS_TOKEN) String access_token);
}
