package com.entertech.edevn.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.entertech.edevn.R;

import static java.lang.Thread.sleep;

public class VerificationActivity extends AppCompatActivity {

    private String email;
    private TextView textEmailShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        textEmailShow = findViewById(R.id.text_email_show);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            email = bundle.getString("email");
            textEmailShow.setText(email);
        }
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(9000);
                    Intent intent = new Intent(VerificationActivity.this, OTPVerificationActivity.class);

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