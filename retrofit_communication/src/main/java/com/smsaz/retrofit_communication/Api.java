package com.smsaz.retrofit_communication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://webhook.site/";

    @GET("d0226baa-5937-4a87-b684-dc30d3b3140b/")
    Call<RetroObject> getObject();

}
