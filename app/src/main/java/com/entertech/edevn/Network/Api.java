package com.entertech.edevn.Network;

import com.entertech.edevn.Model.PojoClass.FreeLivePojoClass;
import com.entertech.edevn.Model.PojoClass.ResumeMainDataClass;
import com.entertech.edevn.Model.PojoClass.SignUpResponse;
import com.entertech.edevn.Model.PojoClass.TeacherListPojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

//    @POST("app-user/signup")
//    Call<SignUpModel> createUser(@Body SignUpModel signUpModel);

//    @POST("app-user/signup")
//    Call<ResponseBody> createUser(@Body SignUpModel signUpModel);

    @FormUrlEncoded
    @POST("app-user/signup")
    Call<SignUpResponse> createUser(@Field("email") String emailOrPhone);

    //get all resume
    @GET("resumestudy")
    Call <ResumeMainDataClass> getAllResumeClass();

    //instructor
    @GET("instructor")
    Call <TeacherListPojo> getAllTeacherList();

    //courses/free-classes
    @GET("courses/free-classes")
    Call <FreeLivePojoClass> getAllFreeLiveClassCourseList();
}
