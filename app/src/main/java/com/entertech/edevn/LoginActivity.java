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

import com.entertech.edevn.Model.SignUpResponse;
import com.entertech.edevn.Network.Api;
import com.entertech.edevn.Model.SignUpModel;
import com.entertech.edevn.Network.RetrofitClient;
import com.entertech.edevn.userManagement.UserPreference;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
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

    private UserPreference userPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        loginContinueButton = (Button) findViewById(R.id.login_continue_btn_id);
        editTextEmailOrPhoneNumber = (EditText)  findViewById(R.id.login_email_or_phone_number_id);

        retrofit = RetrofitClient.getClient();
        api = retrofit.create(Api.class);

        userPreference = new UserPreference(this);

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

        Call<SignUpResponse> call = api.createUser(emailOrPhone);

        call.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {

                if (response.code() == 200){
                    SignUpResponse signUpResponse = response.body();

                    // save user info to userPreference
                    userPreference.saveUser(emailOrPhone);
                    Toast.makeText(LoginActivity.this, signUpResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, LoaderVerificationActivity.class);
                       // intent.putExtra("email",emailOrPhone);
                        startActivity(intent);
                }else{
                    //response from api
                    SignUpResponse signUpResponse = response.body();

                    // user info store userPreference
                    userPreference.saveUser(emailOrPhone);

                    Toast.makeText(LoginActivity.this, "User already exists.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    //intent.putExtra("email",emailOrPhone);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



//        SignUpModel signUpModel = new SignUpModel(emailOrPhone);
//        Call<SignUp> call = retrofitClientApi.createUser("admin@gmail.com");
//        Call call = api.createUser(emailOrPhone);


//        Call<ResponseBody> call = api.createUser(new SignUpModel(emailOrPhone));
//
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
////                Log.d("RRR: ", response.code() + "  Message: " +response.message());
//
//                String s = null;
//
//                try {
//                    if (response.code() == 200){
//
//                        s = response.body().string();
//
//                        Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(LoginActivity.this, LoaderVerificationActivity.class);
//                        intent.putExtra("email",emailOrPhone);
//                        startActivity(intent);
//
//                    }else{
//                        s = response.errorBody().string();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                if (s != null){
//                    try {
//                        JSONObject jsonObject = new JSONObject(s);
//                        Toast.makeText(LoginActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
////
////                if (response.code() == 200)
////                {
////                    Toast.makeText(LoginActivity.this, "Signup successfully.", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(LoginActivity.this, LoaderVerificationActivity.class);
////                    intent.putExtra("email",emailOrPhone);
////                    startActivity(intent);
////                }
////              else  if (response.code() == 409){
////                    Toast.makeText(LoginActivity.this, "OK", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
////                    intent.putExtra("email",emailOrPhone);
////                    startActivity(intent);
////                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
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