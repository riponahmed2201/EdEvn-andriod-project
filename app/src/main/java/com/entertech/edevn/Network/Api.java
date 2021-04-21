package com.entertech.edevn.Network;

import com.entertech.edevn.Model.SignUpModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("app-user/signup")
    Call<SignUpModel> createUser(@Body SignUpModel signUpModel);
}
