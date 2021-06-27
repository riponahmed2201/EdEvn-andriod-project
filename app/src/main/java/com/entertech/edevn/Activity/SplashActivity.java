package com.entertech.edevn.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.entertech.edevn.R;

import java.util.function.Predicate;

import static java.lang.Thread.sleep;


public class SplashActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private String checkLoginPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences= getSharedPreferences("loginCheck",MODE_PRIVATE);
        checkLoginPreference = sharedPreferences.getString("checkLogin","");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    /*Intent intent = new Intent(SplashActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();*/

                    if (checkLoginPreference.equals("true")){
                        Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finish();
                        startActivity(intent);
                    }else if(!checkLoginPreference.equals("true")){
                        Intent intent = new Intent(SplashActivity.this, WelcomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
//                    Log.d("FFFFFF",checkLoginPreference);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }
}