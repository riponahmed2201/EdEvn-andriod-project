package com.entertech.edevn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.entertech.edevn.Model.FreeLiveModelClass;
import com.entertech.edevn.Model.PojoClass.FreeLiveCourse;
import com.entertech.edevn.Model.PojoClass.FreeLiveMainDataClass;
import com.entertech.edevn.Network.Api;
import com.entertech.edevn.Network.RetrofitClient;
import com.entertech.edevn.R;
import com.entertech.edevn.Utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FreeLiveClassActivity extends AppCompatActivity {

    private ImageView liveClassBackId;
    private LinearLayout bookNowId;

    private Api api;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_live_class);

        liveClassBackId = findViewById(R.id.live_class_back_Id);
        bookNowId = findViewById(R.id.book_now_id);

        retrofit = RetrofitClient.getClient();
        api = retrofit.create(Api.class);

        liveClassBackId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FreeLiveClassActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bookNowId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FreeLiveClassActivity.this, BookNowActivity.class);
                startActivity(intent);
            }
        });

        //api call for getAllFreeClassList
        getAllFreeClassList();
    }

   private void getAllFreeClassList(){
       Call<FreeLiveMainDataClass> call = api.getAllFreeClassList();
       call.enqueue(new Callback<FreeLiveMainDataClass>() {
           @Override
           public void onResponse(Call<FreeLiveMainDataClass> call, Response<FreeLiveMainDataClass> response) {
               if (response.code() == 200){
                   Utils.freeLveClassArrayList.clear();
                   FreeLiveMainDataClass freeLiveMainDataClass = response.body();
                   if (freeLiveMainDataClass.getCourses().size() > 0){
                       for (){

                       }
                   }
               }
           }

           @Override
           public void onFailure(Call<FreeLiveMainDataClass> call, Throwable t) {

           }
       });

    }
}