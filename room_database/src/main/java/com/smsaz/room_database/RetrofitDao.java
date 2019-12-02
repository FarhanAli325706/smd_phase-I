package com.smsaz.room_database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RetrofitDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(RetrofitObject retrofitObject);

    @Query("DELETE FROM retrofit_object")
    void deleteAll();

    @Query("SELECT * FROM retrofit_object")
    LiveData<List<RetrofitObject>> getAllRetrofitObjects();
}
