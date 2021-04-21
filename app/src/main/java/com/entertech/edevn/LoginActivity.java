package com.entertech.edevn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.entertech.edevn.Network.Api;
import com.entertech.edevn.Model.SignUpModel;
import com.entertech.edevn.Network.RetrofitClient;

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

    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        loginContinueButton = (Button) findViewById(R.id.login_continue_btn_id);
        editTextEmailOrPhoneNumber = (EditText)  findViewById(R.id.login_email_or_phone_number_id);

        retrofit = RetrofitClient.getClient();

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
        SignUpModel signUpModel = new SignUpModel(emailOrPhone);
//        Call<SignUp> call = retrofitClientApi.createUser("admin@gmail.com");
        Call<SignUpModel> call = api.createUser(signUpModel);

        call.enqueue(new Callback<SignUpModel>() {
            @Override
            public void onResponse(Call<SignUpModel> call, Response<SignUpModel> response)
            {
                if (response.code() == 200)
                {
//                    ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
//                    progressDialog.setCancelable(false);
//                    progressDialog.setIndeterminate(false);
//                    progressDialog.setTitle("Create an account.");
//                    progressDialog.show();

                    Toast.makeText(LoginActivity.this, "Signup successfully.", Toast.LENGTH_SHORT).show();

                    Toast.makeText(LoginActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();

                    Log.d("RRR: ", response.body().toString() + "  Message: " +response.message());

                    Intent intent = new Intent(LoginActivity.this, LoaderVerificationActivity.class);
                    intent.putExtra("email",emailOrPhone);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "error: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignUpModel> call, Throwable t) {
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