package com.entertech.edevn.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.entertech.edevn.R;

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