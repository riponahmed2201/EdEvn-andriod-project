package com.entertech.edevn.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.entertech.edevn.Fragment.HomeFragment;
import com.entertech.edevn.Model.PojoClass.SignUpResponse;
import com.entertech.edevn.Network.Api;
import com.entertech.edevn.Network.RetrofitClient;
import com.entertech.edevn.R;
import com.entertech.edevn.userManagement.UserPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private Button loginContinueButton;
    private EditText editTextEmailOrPhoneNumber;
    String emailOrPhone;
    private Api api;
    Retrofit retrofit;
    private UserPreference userPreference;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        editor = getSharedPreferences("loginCheck", MODE_PRIVATE).edit();

        loginContinueButton = (Button) findViewById(R.id.login_continue_btn_id);
        editTextEmailOrPhoneNumber = (EditText) findViewById(R.id.login_email_or_phone_number_id);

        retrofit = RetrofitClient.getClient();
        api = retrofit.create(Api.class);

        userPreference = new UserPreference(this);

        loginContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isConnected(LoginActivity.this)) {
                    showCustomDialog();
                } else {
                    emailOrPhone = editTextEmailOrPhoneNumber.getText().toString().trim();

                    if (emailOrPhone.isEmpty()) {
                        editTextEmailOrPhoneNumber.setError("Email is required.");
                        editTextEmailOrPhoneNumber.requestFocus();
                        return;
                    }

                    if (!Patterns.EMAIL_ADDRESS.matcher(emailOrPhone).matches()) {
                        editTextEmailOrPhoneNumber.setError("Please enter a valid email.");
                        editTextEmailOrPhoneNumber.requestFocus();
                        return;
                    }

                    createUser();
                }


            }
        });
    }


    //Internet connection check method
    public boolean isConnected(LoginActivity loginActivity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) loginActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected())) {
            return true;
        } else {
            return false;
        }
    }

    //Dialog message method for Internet connection
    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("Please connect to the internet to proceed further")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
                        finish();
                    }
                });

        AlertDialog alert = builder.create();
        //Setting the title manually
        //alert.setTitle("AlertDialogExample");
        alert.show();
    }

    //Create user or SignUp method
    private void createUser() {
        Call<SignUpResponse> call = api.createUser(emailOrPhone);

        call.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {

                if (response.code() == 200) {
                    SignUpResponse signUpResponse = response.body();

                    // save user info to userPreference
                    userPreference.saveUser(emailOrPhone);
                    Toast.makeText(LoginActivity.this, signUpResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, LoaderVerificationActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    // intent.putExtra("email",emailOrPhone);
                    startActivity(intent);
                    editor.putString("checkLogin", "true");
                    editor.apply();
                } else {
                    //response from api
                    SignUpResponse signUpResponse = response.body();

                    // user info store userPreference
                    userPreference.saveUser(emailOrPhone);

                    Toast.makeText(LoginActivity.this, "Logged in successfully.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    finish();
                    //intent.putExtra("email",emailOrPhone);
                    startActivity(intent);
                    editor.putString("checkLogin", "true");
                    editor.apply();
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void userSignUp() {
        String emailOrPhone = editTextEmailOrPhoneNumber.getText().toString().trim();

        if (emailOrPhone.isEmpty()) {
            editTextEmailOrPhoneNumber.setError("Email is required.");
            editTextEmailOrPhoneNumber.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(emailOrPhone).matches()) {
            editTextEmailOrPhoneNumber.setError("Please enter a valid email.");
            editTextEmailOrPhoneNumber.requestFocus();
            return;
        }
    }
}