package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.models;

import android.content.Context;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.dataagents.EventsDataAgent;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.dataagents.HttpUrlConnectionDataAgentImpl;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.dataagents.OkHttpDataAgentImpl;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.dataagents.RetrofitDataAgentImpl;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.persistence.EventDatabase;

public abstract class BaseModel {

    protected EventsDataAgent mDataAgent;
    protected EventDatabase eventDatabase;

    BaseModel(Context context){
        //mDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
        //mDataAgent = OkHttpDataAgentImpl.getObjInstance();
        mDataAgent = RetrofitDataAgentImpl.getObjInstance();
        eventDatabase = EventDatabase.getObjInstance(context);
    }
}
