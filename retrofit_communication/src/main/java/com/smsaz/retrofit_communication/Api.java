package com.smsaz.retrofit_communication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://webhook.site/";

    @GET("3727f764-5d19-434a-9ef6-2bc66b63115b/")
    Call<RetroObject> getObject();

}
