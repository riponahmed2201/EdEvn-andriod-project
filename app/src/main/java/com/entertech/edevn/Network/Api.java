package com.entertech.edevn.Network;

import com.entertech.edevn.Model.SignUpModel;
import com.entertech.edevn.Model.SignUpResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

//    @POST("app-user/signup")
//    Call<SignUpModel> createUser(@Body SignUpModel signUpModel);

//    @POST("app-user/signup")
//    Call<ResponseBody> createUser(@Body SignUpModel signUpModel);

    @FormUrlEncoded
    @POST("app-user/signup")
    Call<SignUpResponse> createUser(@Field("email") String emailOrPhone);
}
