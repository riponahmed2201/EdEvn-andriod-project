package com.entertech.edevn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import static java.lang.Thread.sleep;

public class LoaderVerificationActivity extends AppCompatActivity {

    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader_verfication);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            email = bundle.getString("email");
        }
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(LoaderVerificationActivity.this, OTPVerificationActivity.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }
}