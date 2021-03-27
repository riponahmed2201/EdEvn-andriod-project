package com.entertech.edevn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button loginContinueButton;
    private EditText loginEmailOrPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acvity);

        loginContinueButton = (Button) findViewById(R.id.login_continue_btn_id);
        loginEmailOrPhoneNumber = (EditText)  findViewById(R.id.login_email_or_phone_number_id);

        loginContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}