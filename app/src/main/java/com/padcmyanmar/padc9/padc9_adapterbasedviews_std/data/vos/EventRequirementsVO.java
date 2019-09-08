package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class EventRequirementsVO {

    @SerializedName("gender")
    @ColumnInfo(name = "gender")
    private int gender;

    @SerializedName("age_range")
    @ColumnInfo(name = "age_range")
    private String ageRange;

    @SerializedName("privacy")
    @ColumnInfo(name = "privacy")
    private String privacy;

    @SerializedName("max_people_available")
    @ColumnInfo(name = "max_people_available")
    private String maxPeopleAvailable;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getMaxPeopleAvailable() {
        return maxPeopleAvailable;
    }

    public void setMaxPeopleAvailable(String maxPeopleAvailable) {
        this.maxPeopleAvailable = maxPeopleAvailable;
    }
}
