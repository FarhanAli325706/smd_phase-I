package com.smsaz.room_database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "retrofit_object")
public class RetrofitObject {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "status_code")
    private int statusCode;

    @ColumnInfo(name = "app_version")
    private float appVersion;

    private String app_meta_data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public float getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(float appVersion) {
        this.appVersion = appVersion;
    }

    public String getApp_meta_data() {
        return app_meta_data;
    }

    public void setApp_meta_data(String app_meta_data) {
        this.app_meta_data = app_meta_data;
    }
}
