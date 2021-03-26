package com.entertech.edevn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ClassSelectActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox classSixSelectCheckbox, classSevenSelectCheckbox, classEightSelectCheckbox, classNineSelectCheckbox, classTenSelectCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_select);

        classSixSelectCheckbox = findViewById(R.id.class_six_id);
        classSevenSelectCheckbox = findViewById(R.id.class_seven_id);
        classEightSelectCheckbox = findViewById(R.id.class_eight_id);
        classNineSelectCheckbox = findViewById(R.id.class_nine_id);
        classTenSelectCheckbox = findViewById(R.id.class_ten_id);

        classSixSelectCheckbox.setOnClickListener(this);
        classSevenSelectCheckbox.setOnClickListener(this);
        classEightSelectCheckbox.setOnClickListener(this);
        classNineSelectCheckbox.setOnClickListener(this);
        classTenSelectCheckbox.setOnClickListener(this);


//        classSixSelectCheckbox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ClassSelectActivity.this, WaitClassActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void onClick(View v) {

//        switch (v.getId()){
//            case R.id.class_six_id:
//                Toast.makeText(this, "You clicked class six", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(ClassSelectActivity.this, WaitClassActivity.class);
//                startActivity(intent);
//        }

        if (v.getId() == R.id.class_six_id){
            Toast.makeText(this, "You clicked class six", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ClassSelectActivity.this, WaitClassActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.class_seven_id){
            Toast.makeText(this, "You clicked class seven", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ClassSelectActivity.this, WaitClassActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.class_eight_id){
            Toast.makeText(this, "You clicked Class eight", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ClassSelectActivity.this, WaitClassActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.class_nine_id){
            Toast.makeText(this, "You clicked Class nine", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ClassSelectActivity.this, WaitClassActivity.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.class_ten_id){
            Toast.makeText(this, "You clicked Class ten", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ClassSelectActivity.this, WaitClassActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Something Error Found, Please try again...", Toast.LENGTH_SHORT).show();
        }

    }
}