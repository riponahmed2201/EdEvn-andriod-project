package com.entertech.edevn;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginAcvity extends AppCompatActivity {

    private Button loginContinueButton;
    private EditText loginEmailOrPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acvity);

        loginContinueButton = (Button) findViewById(R.id.login_continue_btn_id);
        loginEmailOrPhoneNumber = (EditText)  findViewById(R.id.login_email_or_phone_number_id);
    }
}