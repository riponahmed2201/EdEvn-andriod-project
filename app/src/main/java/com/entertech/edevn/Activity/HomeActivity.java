package com.entertech.edevn.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.entertech.edevn.Adapter.ResumeStudyAdapter;
import com.entertech.edevn.Model.PojoClass.ResumeMainDataClass;
import com.entertech.edevn.Model.PojoClass.ResumeStudy;
import com.entertech.edevn.Model.ResumeStudyInfo;
import com.entertech.edevn.Network.Api;
import com.entertech.edevn.Network.RetrofitClient;
import com.entertech.edevn.R;
import com.entertech.edevn.Utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "";
    private CardView liveClassDetailsId;
    private LinearLayout homeMathSubId;
    private CardView allResumeStudyList;
    private TextView textViewResult;
    private RecyclerView resumeStudyRecyclerViewId;
    private LinearLayoutManager linearLayoutManager;

    Toolbar toolbar;

    private Api api;

    Retrofit retrofit;

    ResumeStudyInfo resumeStudyInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        liveClassDetailsId = findViewById(R.id.live_class_details_Id);
        homeMathSubId = findViewById(R.id.home_math_sub_Id);
        toolbar = findViewById(R.id.home_menu_tool_bar_id);
        allResumeStudyList = findViewById(R.id.all_resume_study_list);
        resumeStudyRecyclerViewId = findViewById(R.id.resume_study_recycler_view_id);

        setSupportActionBar(toolbar);

        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        resumeStudyRecyclerViewId.setLayoutManager(linearLayoutManager);

        //for live class intent class switch to live class activity
        liveClassDetailsId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FreeLiveClassActivity.class);
                startActivity(intent);
            }
        });

        //for subject details class intent class switch to subject details class activity
        homeMathSubId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SubjectDetailsActivity.class);
                startActivity(intent);
            }
        });

        // object create api
        retrofit = RetrofitClient.getClient();
        api = retrofit.create(Api.class);

        // get all resume study api
        getResumeStudyClass();

    }

    private void getResumeStudyClass(){
        Call<ResumeMainDataClass> call = api.getAllResumeClass();
        call.enqueue(new Callback<ResumeMainDataClass>() {
            @Override
            public void onResponse(Call<ResumeMainDataClass> call, Response<ResumeMainDataClass> response) {
                if (response.code() == 200){
                    Utils.resumeStudyInfoArrayList.clear();
                    ResumeMainDataClass resumeMainDataClass = response.body();
                    if(resumeMainDataClass.getResumeStudy().size() > 0){
                       for (ResumeStudy resumeStudy : resumeMainDataClass.getResumeStudy()){
//                           Log.d("Data", "onResponse: " + resumeStudy.getChapterName());
                           resumeStudyInfo = new ResumeStudyInfo(resumeStudy.getId(),resumeStudy.getUserId(),resumeStudy.getCategoryId(),
                                   resumeStudy.getTotalLesson(), resumeStudy.getIsCompletedLesson(), resumeStudy.getChapterName(),
                                   resumeStudy.getCoverImage(), resumeStudy.getCreatedAt(), resumeStudy.getUpdatedAt());

                           Utils.resumeStudyInfoArrayList.add(resumeStudyInfo);

                       }
                        ResumeStudyAdapter resumeStudyAdapter = new ResumeStudyAdapter(HomeActivity.this);
                        resumeStudyRecyclerViewId.setAdapter(resumeStudyAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResumeMainDataClass> call, Throwable t) {

            }
        });
    }

    //menu bar all code here
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home_menu_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.share_menu_id)
        {
            Toast.makeText(this, "You Click share menu", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.logout_menu_id)
        {
            Toast.makeText(this, "Logout successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

//        else if (id == R.id.update_profile_menu_id)
//        {
//            Intent intent = new Intent(HomeActivity.this, UpdateProfileActivity.class);
//            startActivity(intent);
//        }
//
//        else if (id == R.id.view_profile_menu_id)
//        {
//            Intent intent = new Intent(HomeActivity.this, ViewProfileActivity.class);
//            startActivity(intent);
//        }

        return super.onOptionsItemSelected(item);
    }

}