package com.padcmyanmar.padc9.padc9_adapterbasedviews_std;

import android.app.Application;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.models.EventModelImpl;

public class EventsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EventModelImpl.initializeEventModel(getApplicationContext());
    }
}
