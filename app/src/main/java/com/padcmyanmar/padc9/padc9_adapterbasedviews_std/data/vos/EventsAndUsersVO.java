package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class EventsAndUsersVO {

    @Embedded
    EventVO eventVO;

    @Relation(parentColumn = "id", entityColumn = "event_id")
    List<UserVO> userVOS;

    public EventVO getEventVO() {
        return eventVO;
    }

    public void setEventVO(EventVO eventVO) {
        this.eventVO = eventVO;
    }

    public List<UserVO> getUserVOS() {
        return userVOS;
    }

    public void setUserVOS(List<UserVO> userVOS) {
        this.userVOS = userVOS;
    }
}
