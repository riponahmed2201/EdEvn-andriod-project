package com.entertech.edevn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LiveClassActivity extends AppCompatActivity {

    private ImageView liveClassBackId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_class);

        liveClassBackId = findViewById(R.id.live_class_back_Id);

        liveClassBackId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LiveClassActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}