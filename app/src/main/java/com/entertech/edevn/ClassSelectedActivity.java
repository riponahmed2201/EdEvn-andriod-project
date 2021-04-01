package com.entertech.edevn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClassSelectedActivity extends AppCompatActivity {

    private Button startLearningButtonId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_selected);

        startLearningButtonId = findViewById(R.id.start_learning_buttion_id);

        startLearningButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassSelectedActivity.this, LoaderClassRoomActivity.class);
                startActivity(intent);
            }
        });
    }
}