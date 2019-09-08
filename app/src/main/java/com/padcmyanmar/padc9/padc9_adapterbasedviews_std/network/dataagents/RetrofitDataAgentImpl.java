package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.dataagents;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.responses.EventsApi;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.utils.EventsConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements EventsDataAgent {

    private static RetrofitDataAgentImpl objInstance;

    private EventsApi eventsApi;

    public RetrofitDataAgentImpl() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(EventsConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        eventsApi = retrofit.create(EventsApi.class);
    }

    public static RetrofitDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new RetrofitDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(String access_token, final GetEventsFromNetworkDelegate delegate) {
        Call<GetEventsResponse> eventsResponseCall = eventsApi.getAllEvents(access_token);
        eventsResponseCall.enqueue(new Callback<GetEventsResponse>() {
            @Override
            public void onResponse(Call<GetEventsResponse> call, Response<GetEventsResponse> response) {
                GetEventsResponse getEventsResponse = response.body();
                delegate.onSuccess(getEventsResponse.getEventVOList());
            }

            @Override
            public void onFailure(Call<GetEventsResponse> call, Throwable t) {
                delegate.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
