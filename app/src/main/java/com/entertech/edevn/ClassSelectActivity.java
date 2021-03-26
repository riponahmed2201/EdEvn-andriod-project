package com.entertech.edevn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class ClassSelectActivity extends AppCompatActivity {

    private CheckBox classSelectCheckbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_select);

        classSelectCheckbox = findViewById(R.id.class_six_id);

        classSelectCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassSelectActivity.this, WaitClassActivity.class);
                startActivity(intent);
            }
        });
    }
}