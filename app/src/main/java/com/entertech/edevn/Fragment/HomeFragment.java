package com.entertech.edevn.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.entertech.edevn.Activity.FreeLiveClassActivity;
import com.entertech.edevn.Activity.HomeActivity;
import com.entertech.edevn.Activity.SubjectDetailsActivity;
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

public class HomeFragment extends Fragment {

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
    private View view;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        liveClassDetailsId = view.findViewById(R.id.live_class_details_Id);
        homeMathSubId = view.findViewById(R.id.home_math_sub_Id);
        toolbar = view.findViewById(R.id.home_menu_tool_bar_id);
        allResumeStudyList = view.findViewById(R.id.all_resume_study_list);
        resumeStudyRecyclerViewId = view.findViewById(R.id.resume_study_recycler_view_id);


        linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        resumeStudyRecyclerViewId.setLayoutManager(linearLayoutManager);

        //for live class intent class switch to live class activity
        liveClassDetailsId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FreeLiveClassActivity.class);
                startActivity(intent);
            }
        });

        //for subject details class intent class switch to subject details class activity
        homeMathSubId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SubjectDetailsActivity.class);
                startActivity(intent);
            }
        });

        // object create api
        retrofit = RetrofitClient.getClient();
        api = retrofit.create(Api.class);

        // get all resume study api
        getResumeStudyClass();

        return view;
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
                        ResumeStudyAdapter resumeStudyAdapter = new ResumeStudyAdapter(getContext());
                        resumeStudyRecyclerViewId.setAdapter(resumeStudyAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ResumeMainDataClass> call, Throwable t) {

            }
        });
    }

}