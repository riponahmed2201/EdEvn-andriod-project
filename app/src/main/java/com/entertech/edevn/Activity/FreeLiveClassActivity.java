package com.entertech.edevn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.entertech.edevn.Model.TeacherListModel;
import com.entertech.edevn.Network.Api;
import com.entertech.edevn.Network.RetrofitClient;
import com.entertech.edevn.R;

import retrofit2.Retrofit;

public class FreeLiveClassActivity extends AppCompatActivity {

    private ImageView liveClassBackId;
    private LinearLayout bookNowId;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView liveClassRecyclerViewId;
    TeacherListModel teacherListModel;
    private Api api;

    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_live_class);

        liveClassBackId = findViewById(R.id.live_class_back_Id);
        bookNowId = findViewById(R.id.book_now_id);

        liveClassRecyclerViewId = findViewById(R.id.live_class_teacher_list_recycler_view_id);

        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        liveClassRecyclerViewId.setLayoutManager(linearLayoutManager);

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

        // object create api
        retrofit = RetrofitClient.getClient();
        api = retrofit.create(Api.class);

        //api call method getAlTeacherList()
        getAlTeacherList();
    }

    private void getAlTeacherList() {

    }

}