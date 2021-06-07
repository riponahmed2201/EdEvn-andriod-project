package com.entertech.edevn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.entertech.edevn.R;

public class UpdateProfileActivity extends AppCompatActivity {

    ImageView updateProfileBackButtonId;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        setSupportActionBar(toolbar);

        updateProfileBackButtonId = findViewById(R.id.update_profile_back_btn_id);

        updateProfileBackButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateProfileActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}