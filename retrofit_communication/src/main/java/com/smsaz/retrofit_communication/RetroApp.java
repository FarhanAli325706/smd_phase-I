package com.smsaz.retrofit_communication;

import com.google.gson.annotations.SerializedName;

public class RetroApp {
    @SerializedName("version:")
    private Double version;

    @SerializedName("app_meta_name")
    private String appName;

    public RetroApp(Double version, String appName) {
        this.version = version;
        this.appName = appName;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
