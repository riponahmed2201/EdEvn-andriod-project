package com.entertech.edevn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private CardView liveClassDetailsId;
    private LinearLayout homeMathSubId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        liveClassDetailsId = findViewById(R.id.live_class_details_Id);
        homeMathSubId = findViewById(R.id.home_math_sub_Id);

        //for live class intent class switch to live class activity
        liveClassDetailsId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LiveClassActivity.class);
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
    }
}