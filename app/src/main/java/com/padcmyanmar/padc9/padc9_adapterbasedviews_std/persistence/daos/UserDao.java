package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.vos.UserVO;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<UserVO> getAllUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertUsers(List<UserVO> userVOS);

}
