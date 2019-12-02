package com.smsaz.room_database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RetorfitObjectRepository {
    private RetrofitDao retrofitDao;
    private LiveData<List<RetrofitObject>> retrofitLiveData;

    public RetorfitObjectRepository(Context context) {
        RetrofitDatabase db = RetrofitDatabase.getInstance(context);
        retrofitDao = db.getRetrofitDao();
        retrofitLiveData = retrofitDao.getAllRetrofitObjects();
    }

    LiveData<List<RetrofitObject>> getRetrofitLiveData() {
        return retrofitLiveData;
    }

    public void insert (RetrofitObject retrofitObject) {
        new insertAsyncTask(retrofitDao).execute(retrofitObject);
    }

    private static class insertAsyncTask extends AsyncTask<RetrofitObject, Void, Void> {

        private RetrofitDao mAsyncTaskDao;

        insertAsyncTask(RetrofitDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final RetrofitObject... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}