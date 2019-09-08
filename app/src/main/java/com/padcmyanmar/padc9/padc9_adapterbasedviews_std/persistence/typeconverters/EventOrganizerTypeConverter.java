package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventOrganizerVO;

public class EventOrganizerTypeConverter {

    @TypeConverter
    public static String eventOrganizerToJson(EventOrganizerVO eventOrganizerVO){
        return new Gson().toJson(eventOrganizerVO);
    }

    @TypeConverter
    public static EventOrganizerVO jsonToEventOrganizer(String eventOrganizerJson){
        return new Gson().fromJson(eventOrganizerJson, EventOrganizerVO.class);
    }
}
