package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.UserVO;

import java.lang.reflect.Type;
import java.util.List;

public class UserListTypeConverter {

    @TypeConverter
    public static String userListToJson(List<UserVO> list){
        return new Gson().toJson(list);
    }

    @TypeConverter
    public static List<UserVO> jsonToUserList(String userListJson){
        Type listType = new TypeToken<List<UserVO>>(){}.getType();
        return new Gson().fromJson(userListJson, listType);
    }
}
