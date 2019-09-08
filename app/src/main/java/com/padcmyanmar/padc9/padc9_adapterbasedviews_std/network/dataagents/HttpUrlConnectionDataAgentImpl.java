package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.dataagents;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.responses.GetEventsResponse;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.utils.EventsConstants;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class HttpUrlConnectionDataAgentImpl implements EventsDataAgent{

    private static HttpUrlConnectionDataAgentImpl objInstance;

    public static HttpUrlConnectionDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new HttpUrlConnectionDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getEvents(String access_token, GetEventsFromNetworkDelegate delegate) {
        new GetEventsTask(EventsConstants.DUMMY_ACCESS_TOKEN, delegate).execute();
    }

    public static class GetEventsTask extends AsyncTask<Void, Void, GetEventsResponse>{

        private String accessToken;
        private GetEventsFromNetworkDelegate newsResponseDelegate;

        public GetEventsTask(String accessToken, GetEventsFromNetworkDelegate delegate) {
            this.accessToken = accessToken;
            this.newsResponseDelegate = delegate;
        }


        @Override
        protected GetEventsResponse doInBackground(Void... voids) {

            URL url;
            BufferedReader bufferedReader = null;
            StringBuilder stringBuilder;

            try {
                url = new URL(EventsConstants.BASE_URL + EventsConstants.GET_EVENTS);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod("POST");

                //give it 15seconds to respond
                connection.setReadTimeout(15 * 1000);

                connection.setDoInput(true);
                connection.setDoOutput(true);

                //put the request parameter into NameValuePair list.
                List<NameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair(EventsConstants.PARAM_ACCESS_TOKEN, accessToken));

                //write the parameter into NameValuePair list into connection object.
                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(outputStream, "UTF-8"));
                writer.write(getQuery(params));
                writer.flush();
                writer.close();
                outputStream.close();

                connection.connect();

                //read the output from the server
                bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                stringBuilder = new StringBuilder();

                String line = null;
                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line + "\n");
                }

                String responseString = stringBuilder.toString();

                GetEventsResponse response = new Gson().fromJson(responseString, GetEventsResponse.class);

                return response;

            } catch (Exception e){

            }finally {
                //close the reader; this can throw an exception too, so
                //wrap it in another try/catch block.
                if(bufferedReader != null){
                    try {
                        bufferedReader.close();
                    }catch (IOException ioe){
                        ioe.printStackTrace();
                    }
                }
            }
            return null;
        }

        private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {

            StringBuilder result = new StringBuilder();
            boolean first = true;

            for(NameValuePair pair : params){
                if (first){
                    first = false;
                }else {
                    result.append("&");
                }

                result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
            }
            return result.toString();
        }

        @Override
        protected void onPostExecute(GetEventsResponse eventsResponse) {
            super.onPostExecute(eventsResponse);

            if(eventsResponse != null){
                if (eventsResponse.isResponseOk()){
                    newsResponseDelegate.onSuccess(eventsResponse.getEventVOList());
                }else {
                    newsResponseDelegate.onFailure(eventsResponse.getMessage());
                }
            }else {
                newsResponseDelegate.onFailure(EventsConstants.EM_NULL_EVENT_RESPONSE);
            }
        }
    }

}
