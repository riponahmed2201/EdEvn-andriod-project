package com.entertech.edevn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.entertech.edevn.R;

public class ViewProfileActivity extends AppCompatActivity {

    ImageView viewProfileBackButtonId;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        setSupportActionBar(toolbar);

        viewProfileBackButtonId = findViewById(R.id.view_profile_back_btn_id);

        viewProfileBackButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}