package com.entertech.edevn.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.entertech.edevn.Activity.FreeLiveClassActivity;
import com.entertech.edevn.Activity.LiveClassActivity;
import com.entertech.edevn.Adapter.TeacherListAdapter;
import com.entertech.edevn.Model.PojoClass.Instructor;
import com.entertech.edevn.Model.PojoClass.TeacherListPojo;
import com.entertech.edevn.Model.TeacherListModel;
import com.entertech.edevn.Network.Api;
import com.entertech.edevn.Network.RetrofitClient;
import com.entertech.edevn.R;
import com.entertech.edevn.Utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class LiveClassFragment extends Fragment {

    private View view;
    private CardView liveClassDetailsId;

    private LinearLayoutManager linearLayoutManager;
    private RecyclerView liveClassRecyclerViewId;
    TeacherListModel teacherListModel;
    private Api api;
    Retrofit retrofit;

    public LiveClassFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_live_class, container, false);
         liveClassDetailsId = view.findViewById(R.id.live_class_details_Id);

        liveClassRecyclerViewId = view.findViewById(R.id.all_teacher_list_recycler_view_id);

        linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        liveClassRecyclerViewId.setLayoutManager(linearLayoutManager);

         liveClassDetailsId.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getContext(), FreeLiveClassActivity.class);
                 startActivity(intent);
             }
         });

        // object create api
        retrofit = RetrofitClient.getClient();
        api = retrofit.create(Api.class);

        //api call method getAlTeacherList()
        getAlTeacherList();

         return view;
    }

    private void getAlTeacherList() {
        Call<TeacherListPojo> call = api.getAllTeacherList();
        call.enqueue(new Callback<TeacherListPojo>() {
            @Override
            public void onResponse(Call<TeacherListPojo> call, Response<TeacherListPojo> response) {
                if (response.code() == 200){
                    Utils.teacherListModelArrayList.clear();
                    TeacherListPojo teacherListPojo = response.body();
                    if (teacherListPojo.getInstructors().size() > 0){
                        for (Instructor instructor: teacherListPojo.getInstructors()){
                            //Log.d("Data", "onResponse: " + instructor.getName());
                            teacherListModel = new TeacherListModel(instructor.getId(),instructor.getName(),instructor.getEmail(),instructor.getPhone(), instructor.getUserImage());
                            Utils.teacherListModelArrayList.add(teacherListModel);
                            Log.d("Data", "onResponse: " + instructor.getName());
                        }

                        TeacherListAdapter teacherListAdapter =  new TeacherListAdapter(getContext());
                        liveClassRecyclerViewId.setAdapter(teacherListAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<TeacherListPojo> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}