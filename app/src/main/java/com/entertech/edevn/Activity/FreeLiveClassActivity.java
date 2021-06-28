package com.entertech.edevn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.entertech.edevn.Adapter.FreeLiveClassAdapter;
import com.entertech.edevn.Model.FreeLiveClassModel;
import com.entertech.edevn.Model.PojoClass.Course;
import com.entertech.edevn.Model.PojoClass.FreeLivePojoClass;
import com.entertech.edevn.Model.TeacherListModel;
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
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView freeLiveClassListRecyclerViewId;
    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_live_class);

        liveClassBackId = findViewById(R.id.live_class_back_Id);
       // bookNowId = findViewById(R.id.book_now_id);

        freeLiveClassListRecyclerViewId = findViewById(R.id.free_live_class_list_recycler_view_id);

        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        freeLiveClassListRecyclerViewId.setLayoutManager(linearLayoutManager);

        liveClassBackId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FreeLiveClassActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

//        bookNowId.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(FreeLiveClassActivity.this, BookNowActivity.class);
//                startActivity(intent);
//            }
//        });

        // object create api
        retrofit = RetrofitClient.getClient();
        api = retrofit.create(Api.class);

        //getAllFreeLiveClassCourseList
        getAllFreeLiveClassCourseList();
    }

    private void getAllFreeLiveClassCourseList() {
        Call<FreeLivePojoClass> call = api.getAllFreeLiveClassCourseList();
        call.enqueue(new Callback<FreeLivePojoClass>() {
            @Override
            public void onResponse(Call<FreeLivePojoClass> call, Response<FreeLivePojoClass> response) {
                if (response.code() == 200){
                    Utils.freeLiveClassModelArrayList.clear();
                    FreeLivePojoClass freeLivePojoClass = response.body();
                    if (freeLivePojoClass.getCourses().size() > 0){
                        for (Course course: freeLivePojoClass.getCourses()){
                            Log.d("Data", "onResponse: " + course.getTotalSeats());
                            FreeLiveClassModel freeLiveClassModel = new FreeLiveClassModel(course.getCourseId(),course.getCategoryId(),course.getCoursePrice(),course.getIsDownloadable(),course.getTotalSeats(),course.getCourseType(),course.getCourseTitle(),course.getPublishType(),course.getCategoryName(),course.getLavel(),course.getDuration(),course.getLanguage(),course.getPaymentType(),course.getClassTime(),course.getCoverImage());
                            Utils.freeLiveClassModelArrayList.add(freeLiveClassModel);
                        }

                        FreeLiveClassAdapter freeLiveClassAdapter = new FreeLiveClassAdapter(FreeLiveClassActivity.this);
                        freeLiveClassListRecyclerViewId.setAdapter(freeLiveClassAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<FreeLivePojoClass> call, Throwable t) {
                Toast.makeText(FreeLiveClassActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}