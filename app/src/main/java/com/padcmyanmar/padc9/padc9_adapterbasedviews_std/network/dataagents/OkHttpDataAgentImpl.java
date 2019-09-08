package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.dataagents;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.utils.EventsConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpDataAgentImpl implements EventsDataAgent {

    private static OkHttpDataAgentImpl objInstance;

    private OkHttpClient okHttpClient;

    private OkHttpDataAgentImpl(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new OkHttpDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(String access_token, GetEventsFromNetworkDelegate delegate) {
        new GetEventsTask(okHttpClient, access_token, delegate).execute();
    }

    public static class GetEventsTask extends AsyncTask<Void, Void, GetEventsResponse>{

        private OkHttpClient okHttpClient;
        private String access_token;
        private GetEventsFromNetworkDelegate delegate;

        public GetEventsTask(OkHttpClient okHttpClient, String  access_token, GetEventsFromNetworkDelegate delegate) {
            this.okHttpClient = okHttpClient;
            this.access_token = access_token;
            this.delegate = delegate;
        }

        @Override
        protected GetEventsResponse doInBackground(Void... voids) {

            RequestBody formBody = new FormBody.Builder()
                    .add(EventsConstants.DUMMY_ACCESS_TOKEN, access_token)
                    .build();

            Request request = new Request.Builder()
                    .url(EventsConstants.BASE_URL + EventsConstants.GET_EVENTS)
                    .post(formBody)
                    .build();

            try {
                Response response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful()){
                    String responseString = response.body().string();

                    GetEventsResponse getEventsResponse = new Gson().fromJson(responseString, GetEventsResponse.class);
                    return getEventsResponse;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(GetEventsResponse eventsResponse) {
            super.onPostExecute(eventsResponse);

            if (eventsResponse != null){
                if(eventsResponse.isResponseOk()){
                    delegate.onSuccess(eventsResponse.getEventVOList());
                }else {
                    delegate.onFailure(eventsResponse.getMessage());
                }
            }else {
                delegate.onFailure(EventsConstants.EM_NULL_EVENT_RESPONSE);
            }
        }
    }
}
