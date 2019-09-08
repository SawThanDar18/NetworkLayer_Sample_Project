package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventRequirementsVO;

public class EventRequirementsTypeConverter {

    @TypeConverter
    public static String eventRequirementsToJson(EventRequirementsVO eventRequirementsVO){
        return new Gson().toJson(eventRequirementsVO);
    }

    @TypeConverter
    public static EventRequirementsVO jsonToEventRequirements(String eventRequirementsJson){
        return new Gson().fromJson(eventRequirementsJson, EventRequirementsVO.class);
    }
}
