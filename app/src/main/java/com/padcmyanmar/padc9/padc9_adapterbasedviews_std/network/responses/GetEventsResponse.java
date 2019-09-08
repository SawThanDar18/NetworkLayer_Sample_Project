package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.EventVO;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.utils.EventsConstants;

import java.util.List;

public class GetEventsResponse {

    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private List<EventVO> eventVOList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<EventVO> getEventVOList() {
        return eventVOList;
    }

    public void setEventVOList(List<EventVO> eventVOList) {
        this.eventVOList = eventVOList;
    }

    public Boolean isResponseOk(){
        return code == EventsConstants.CODE_RESPONSE_OK && eventVOList != null;
    }
}
