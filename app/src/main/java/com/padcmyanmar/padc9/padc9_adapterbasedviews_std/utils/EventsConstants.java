package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.utils;

public class EventsConstants {

    //Access Token
    public static final String  DUMMY_ACCESS_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8zNC43My45LjIyOFwvYXBpXC9sb2dpbi1ieS1wYXNzd29yZCIsImlhdCI6MTU2NjYxNzcxMSwiZXhwIjoxNTY5Mjk2MTExLCJuYmYiOjE1NjY2MTc3MTEsImp0aSI6InBabm9sMTljTEJ3c05zVFMiLCJzdWIiOjExLCJwcnYiOiJjZGU5NmRlZGNiMzMzODlmMjFhMWRhZjRlY2QyZDc0MWFkMGJlNWUyIn0.pGNd-8Ag_VIvCmrQ9xFzsr-NbLo-I-zvxeYjXXEkzCI";

    //URL
    public static final String BASE_URL = "https://78743814-6e79-4273-8c16-c5afc7b81049.mock.pstmn.io";
    public static final String GET_EVENTS = "/getAllEvents";
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";

    //PARAMS
    public static final String PARAM_ACCESS_TOKEN = "access_token";

    //Error message
    public static final String EM_NULL_EVENT_RESPONSE = "Check Internet Connection";
    public static final String EM_EVENT_MODEL_NOT_INITIALIZED = "Event Model should not have been initialied";

    //Response Code
    public static int CODE_RESPONSE_OK = 200;

    //DB Name
    public static final String EVENT_DB = "EventDB";
}
