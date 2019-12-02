package com.smsaz.retrofit_communication;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.smsaz.room_database.RetorfitObjectRepository;
import com.smsaz.room_database.RetrofitObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCommunicator {

    static RetorfitObjectRepository retorfitObjectRepository;

    public void startCommunication(Context context){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retorfitObjectRepository = new RetorfitObjectRepository(context);

        Api api = retrofit.create(Api.class);

        Call<RetroObject> call = api.getObject();
        call.enqueue(new Callback<RetroObject>() {
            @Override
            public void onResponse(Call<RetroObject> call, Response<RetroObject> response) {

                RetroObject retroObject = response.body();

                //Put data in room_database

                Log.d("status_code", String.valueOf(retroObject.getStatus_code()));
                Log.d("AppVersion: version", String.valueOf(retroObject.getAppVersion().getVersion()));
                Log.d("AppVersion: meta_data", retroObject.getAppVersion().getAppName());

                RetrofitObject retrofitObject = new RetrofitObject();
                retrofitObject.setApp_meta_data(retroObject.getAppVersion().getAppName());
                retrofitObject.setAppVersion(retroObject.getAppVersion().getVersion());
                retrofitObject.setStatusCode(retroObject.getStatus_code());

                retorfitObjectRepository.insert(retrofitObject);
            }

            @Override
            public void onFailure(Call<RetroObject> call, Throwable t) {
                Log.d("Retrofit Failure", "onFailure: " + t.getMessage());
            }
        });
    }


}
