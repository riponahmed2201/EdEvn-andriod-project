package com.entertech.edevn.auth;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("app-user/signup")
    Call<SignUp> createUser(@Body SignUp signUp);
}
