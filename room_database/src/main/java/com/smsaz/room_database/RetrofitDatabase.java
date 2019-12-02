package com.smsaz.room_database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = RetrofitObject.class, version = 1, exportSchema = false)
public abstract class RetrofitDatabase extends RoomDatabase {
    public abstract RetrofitDao getRetrofitDao();

    private static RetrofitDatabase retrofitDatabase;

    public static RetrofitDatabase getInstance(Context context) {
        if (retrofitDatabase == null) {
            synchronized (RetrofitDatabase.class) {
                if (retrofitDatabase == null) {
                    retrofitDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            RetrofitDatabase.class, "retrofit_object")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return retrofitDatabase;
    }

    public void cleanUp() {
        retrofitDatabase = null;
    }
}
