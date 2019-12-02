package com.smsaz.store_in_shared_preferences_and_cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//https://developer.android.com/training/data-storage/shared-preferences

public class SharedPreferencesAndCacheHandler {

    private final String SHARED_PREFERENCES_FILE_NAME = "com.smsaz.fitnessenthusiast.PREFERENCE_FILE_KEY";
    private final String SHARED_PREFERENCES_FILE_KEY = "current_user";
    File cacheFile;

    Context context;

    public SharedPreferencesAndCacheHandler(Context context){
        this.context = context;
    }

    public void storeData(String userEmail){
        SharedPreferences sharedPref = context.getSharedPreferences(this.SHARED_PREFERENCES_FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(this.SHARED_PREFERENCES_FILE_KEY,userEmail);
        editor.apply();
        this.cacheFile = getTempFile(context,"my_cache");

        // TODO: 12/2/2019 cache file not being read by device explorer 

        FileWriter fstream = null;
        try {
            fstream = new FileWriter(cacheFile);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(userEmail);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getTempFile(Context context, String fileName) {
        File file = null;
        try {
            file = File.createTempFile(fileName, null, context.getCacheDir());
        } catch (IOException e) {
            Log.d("getTempFile", e.toString());
        }
        return file;
    }

    public void deleteDataFromSharedPrefFile(){
        SharedPreferences sharedPref = context.getSharedPreferences(this.SHARED_PREFERENCES_FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.commit();
    }

    public void deleteDataFromCache(){
        if(cacheFile != null){
            cacheFile.delete();
            cacheFile = null;
        }
    }

    public void deleteData(){
        deleteDataFromCache();
        deleteDataFromSharedPrefFile();
    }

    public String retreiveData(){
        SharedPreferences sharedPref = context.getSharedPreferences(this.SHARED_PREFERENCES_FILE_NAME,Context.MODE_PRIVATE);
        return sharedPref.getString(this.SHARED_PREFERENCES_FILE_KEY,null);
    }
}
