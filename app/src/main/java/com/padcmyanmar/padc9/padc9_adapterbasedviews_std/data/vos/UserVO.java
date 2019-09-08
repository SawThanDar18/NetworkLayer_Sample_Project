package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "user", foreignKeys = {@ForeignKey(entity = EventVO.class, parentColumns = "id", childColumns = "event_id")},
indices = @Index(value = "event_id", unique = true))
public class UserVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id_pk")
    private int userIdPK;

    @SerializedName("user_name")
    @ColumnInfo(name = "user_name")
    private String userName;

    @SerializedName("email")
    @ColumnInfo(name = "email")
    private String email;

    @SerializedName("phone_number")
    @ColumnInfo(name = "phone_number")
    private String phoneNumber;

    @SerializedName("photo_url")
    @ColumnInfo(name = "photo_url")
    private String photoUrl;

    @SerializedName("cover_photo_url")
    @ColumnInfo(name = "cover_photo_url")
    private String coverUrl;

    @SerializedName("address")
    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "event_id")
    private int eventId;

    public int getUserIdPK() {
        return userIdPK;
    }

    public void setUserIdPK(int userIdPK) {
        this.userIdPK = userIdPK;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
