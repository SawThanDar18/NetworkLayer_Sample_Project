package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventVO;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.UserVO;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.persistence.daos.EventDao;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.persistence.daos.UserDao;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.persistence.typeconverters.UserListTypeConverter;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.utils.EventsConstants;

@Database(entities = {EventVO.class, UserVO.class}, version = 11, exportSchema = false)
@TypeConverters({UserListTypeConverter.class})
public abstract class EventDatabase extends RoomDatabase {

    public abstract EventDao eventDao();
    public abstract UserDao userDao();

    private static EventDatabase objInstance;

    public static EventDatabase getObjInstance(Context context){
        if (objInstance == null){
            objInstance = Room.databaseBuilder(context, EventDatabase.class, EventsConstants.EVENT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return objInstance;
    }

    public boolean areEventsExistInDB(){
        return !eventDao().getAllEvents().isEmpty();
    }
}
