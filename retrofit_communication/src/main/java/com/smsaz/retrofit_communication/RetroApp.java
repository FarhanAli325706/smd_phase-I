package com.smsaz.retrofit_communication;

import com.google.gson.annotations.SerializedName;

public class RetroApp {
    private float version;

    @SerializedName("app_meta_name")
    private String appName;

    public RetroApp(float version, String appName) {
        this.version = version;
        this.appName = appName;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
