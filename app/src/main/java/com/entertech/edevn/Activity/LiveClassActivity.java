package com.entertech.edevn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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

public class LiveClassActivity extends AppCompatActivity {

    private CardView liveClassDetailsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_class);

        liveClassDetailsId = findViewById(R.id.live_class_details_Id);

        liveClassDetailsId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiveClassActivity.this,FreeLiveClassActivity.class);
                startActivity(intent);
            }
        });

    }


}