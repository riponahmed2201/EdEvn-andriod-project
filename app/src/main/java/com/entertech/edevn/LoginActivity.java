package com.entertech.edevn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.entertech.edevn.api.Api;
import com.entertech.edevn.auth.SignUp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private Button loginContinueButton;
    private EditText editTextEmailOrPhoneNumber;
    String emailOrPhone;
    private Api api;
    private String BASE_URL = "https://backend-edevn-server.glitch.me/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        loginContinueButton = (Button) findViewById(R.id.login_continue_btn_id);
        editTextEmailOrPhoneNumber = (EditText)  findViewById(R.id.login_email_or_phone_number_id);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);

        loginContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailOrPhone =  editTextEmailOrPhoneNumber.getText().toString().trim();
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

                createUser();
            }
        });
    }

    private void createUser()
    {
        SignUp signUp = new SignUp(emailOrPhone);
//        Call<SignUp> call = retrofitClientApi.createUser("admin@gmail.com");
        Call<SignUp> call = api.createUser(signUp);

        call.enqueue(new Callback<SignUp>() {
            @Override
            public void onResponse(Call<SignUp> call, Response<SignUp> response) {
                if (!response.isSuccessful()){
                   // textViewResult.setText("Code:"+ response.code());
                    Toast.makeText(LoginActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }

                SignUp signUpResponse = response.body();

//                ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
//                progressDialog.setCancelable(false);
//                progressDialog.setIndeterminate(false);
//                progressDialog.setTitle("Create an account.");
//                progressDialog.show();

                Toast.makeText(LoginActivity.this, response.message(), Toast.LENGTH_SHORT).show();

                String getEmailAfterSignUp = signUpResponse.getEmail();

                Intent intent = new Intent(LoginActivity.this, LoaderVerificationActivity.class);
                intent.putExtra("email",getEmailAfterSignUp);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<SignUp> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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