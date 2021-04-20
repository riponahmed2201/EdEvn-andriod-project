package com.entertech.edevn.api;

import com.entertech.edevn.auth.SignUp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("app-user/signup")
    Call<SignUp> createUser(@Body SignUp signUp);
}
