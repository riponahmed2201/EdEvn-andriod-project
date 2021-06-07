package com.entertech.edevn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.entertech.edevn.R;

public class SubjectDetailsActivity extends AppCompatActivity {

    private ImageView subjectDetailsBackId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);

        subjectDetailsBackId = findViewById(R.id.subject_details_back_Id);

        subjectDetailsBackId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubjectDetailsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}