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

    public void deleteDataFromCache() {
        try {
            File dir = this.context.getCacheDir();
            SharedPreferencesAndCacheHandler.deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
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
