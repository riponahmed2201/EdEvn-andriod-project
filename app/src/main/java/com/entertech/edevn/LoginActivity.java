package com.entertech.edevn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private Button loginContinueButton;
    private EditText editTextEmailOrPhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        loginContinueButton = (Button) findViewById(R.id.login_continue_btn_id);
        editTextEmailOrPhoneNumber = (EditText)  findViewById(R.id.login_email_or_phone_number_id);

        loginContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailOrPhone =  editTextEmailOrPhoneNumber.getText().toString().trim();
                if (emailOrPhone.isEmpty()){
                    editTextEmailOrPhoneNumber.setError("Email is required.");
                    editTextEmailOrPhoneNumber.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(emailOrPhone).matches()){
                    editTextEmailOrPhoneNumber.setError("Please enter a valid email.");
                    editTextEmailOrPhoneNumber.requestFocus();
                    return;
                }

                Intent intent = new Intent(LoginActivity.this, LoaderVerificationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void userSignUp(){
        String emailOrPhone =  editTextEmailOrPhoneNumber.getText().toString().trim();

        if (emailOrPhone.isEmpty()){
            editTextEmailOrPhoneNumber.setError("Email is required.");
            editTextEmailOrPhoneNumber.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailOrPhone).matches()){
            editTextEmailOrPhoneNumber.setError("Please enter a valid email.");
            editTextEmailOrPhoneNumber.requestFocus();
            return;
        }
    }
}