package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos;

import com.google.gson.annotations.SerializedName;

public class EventOrganizerVO {

    @SerializedName("organizer_name")
    private String organizerName;

    @SerializedName("organizer_photo_url")
    private String organizerPhotoUrl;

    @SerializedName("organizer_role")
    private String organizerRole;

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public String getOrganizerPhotoUrl() {
        return organizerPhotoUrl;
    }

    public void setOrganizerPhotoUrl(String organizerPhotoUrl) {
        this.organizerPhotoUrl = organizerPhotoUrl;
    }

    public String getOrganizerRole() {
        return organizerRole;
    }

    public void setOrganizerRole(String organizerRole) {
        this.organizerRole = organizerRole;
    }
}
