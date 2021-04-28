package com.entertech.edevn.userManagement;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreference {

    private static final String USER_FULL_NAME = "fullName";
    private static final String USER_EMAIL_OR_PHONE = "emailPhone";
    private static final String USER_TOKEN = "token";
    private static final String DEFAULT = "Not found";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public UserPreference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("User",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUser(String emailPhone){
//        editor.putString("fullName",fullName);
        editor.putString("emailPhone",emailPhone);
//        editor.putString("token",token);
        editor.commit();
    }

    public String fullName(){
        return sharedPreferences.getString(USER_FULL_NAME, DEFAULT);
    }

    public String emailPhone(){
        return sharedPreferences.getString(USER_EMAIL_OR_PHONE, DEFAULT);
    }

    public String token(){
        return sharedPreferences.getString(USER_TOKEN, DEFAULT);
    }

    public void resetUser(){
        editor.clear();
        editor.commit();
    }
}
