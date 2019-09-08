package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventVO;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.UserVO;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long[] insertEvents(List<EventVO> eventVOS);

    @Query("SELECT * FROM event INNER JOIN user WHERE event.id = user.event_id")
    public abstract List<EventVO> getAllEvents();

    @Query("SELECT * FROM event WHERE id = :id")
    public abstract EventVO getEventById(int id);

    public void insertEventsAndUsers(List<EventVO> eventVOList, UserDao userDao){
        List<UserVO> userVOList = new ArrayList<>();

        for(EventVO eventVO : eventVOList){
            for (UserVO goingUser : eventVO.getGoingUser()){
                goingUser.setEventId(eventVO.getId());
            }
            userVOList.addAll(eventVO.getGoingUser());
        }
        insertEvents(eventVOList);
        userDao.insertUsers(userVOList);
    }
}
