package com.smsaz.retrofit_communication;

import com.google.gson.annotations.SerializedName;

public class RetroObject {
    private int status_code;

    @SerializedName("AppVersion")
    private RetroApp appVersion;

    public RetroObject(int status_code, RetroApp appVersion) {
        this.status_code = status_code;
        this.appVersion = appVersion;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public RetroApp getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(RetroApp appVersion) {
        this.appVersion = appVersion;
    }
}
