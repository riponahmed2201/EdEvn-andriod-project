package com.entertech.edevn.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.entertech.edevn.R;

public class ClassSelectActivity extends AppCompatActivity {

    private CheckBox classSixSelectCheckbox, classSevenSelectCheckbox, classEightSelectCheckbox, classNineSelectCheckbox, classTenSelectCheckbox;

    private Button startLearningButtonId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_select);

        classSixSelectCheckbox = findViewById(R.id.class_six_id);
        classSevenSelectCheckbox = findViewById(R.id.class_seven_id);
        classEightSelectCheckbox = findViewById(R.id.class_eight_id);
        classNineSelectCheckbox = findViewById(R.id.class_nine_id);
        classTenSelectCheckbox = findViewById(R.id.class_ten_id);
        startLearningButtonId = findViewById(R.id.start_learning_button_id);

//        classSixSelectCheckbox.setOnClickListener(this);
//        classSevenSelectCheckbox.setOnClickListener(this);
//        classEightSelectCheckbox.setOnClickListener(this);
//        classNineSelectCheckbox.setOnClickListener(this);
//        classTenSelectCheckbox.setOnClickListener(this);
//        startLearningButtonId.setOnClickListener(this);


        startLearningButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (classSixSelectCheckbox.isChecked() || classSevenSelectCheckbox.isChecked()
                || classEightSelectCheckbox.isChecked() || classNineSelectCheckbox.isChecked()
                || classTenSelectCheckbox.isChecked()){

                    if (classSixSelectCheckbox.isChecked()){
                        Toast.makeText(ClassSelectActivity.this, "You selected class six...", Toast.LENGTH_SHORT).show();
                    }
                    if (classSevenSelectCheckbox.isChecked()){
                        Toast.makeText(ClassSelectActivity.this, "You selected class seven...", Toast.LENGTH_SHORT).show();
                    }
                    if (classEightSelectCheckbox.isChecked()){
                        Toast.makeText(ClassSelectActivity.this, "You selected class eight...", Toast.LENGTH_SHORT).show();
                    }
                    if (classNineSelectCheckbox.isChecked()){
                        Toast.makeText(ClassSelectActivity.this, "You selected class nine...", Toast.LENGTH_SHORT).show();
                    }
                    if (classTenSelectCheckbox.isChecked()){
                        Toast.makeText(ClassSelectActivity.this, "You selected class ten...", Toast.LENGTH_SHORT).show();
                    }

                    Intent intent = new Intent(ClassSelectActivity.this, LoaderClassRoomActivity.class);
                   // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

                else{
                      Toast.makeText(ClassSelectActivity.this, "You don't have any selected class, Please select any class...", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

//    @Override
//    public void onClick(View v) {

////        if (v.getId() == R.id.class_six_id){
////            Toast.makeText(this, "You selected class six, Please press start learning button to continue", Toast.LENGTH_SHORT).show();
////        }
////        if (v.getId() == R.id.class_six_id){
////            Toast.makeText(this, "You clicked class six", Toast.LENGTH_SHORT).show();
//////            Intent intent = new Intent(ClassSelectActivity.this, ClassSelectedActivity.class);
//////            startActivity(intent);
////        }
////        else if(v.getId() == R.id.class_seven_id){
////            Toast.makeText(this, "You clicked class seven", Toast.LENGTH_SHORT).show();
////            Intent intent = new Intent(ClassSelectActivity.this, ClassSelectedActivity.class);
////            startActivity(intent);
////        }
////        else if(v.getId() == R.id.class_eight_id){
////            Toast.makeText(this, "You clicked Class eight", Toast.LENGTH_SHORT).show();
////            Intent intent = new Intent(ClassSelectActivity.this, ClassSelectedActivity.class);
////            startActivity(intent);
////        }
////        else if(v.getId() == R.id.class_nine_id){
////            Toast.makeText(this, "You clicked Class nine", Toast.LENGTH_SHORT).show();
////            Intent intent = new Intent(ClassSelectActivity.this, ClassSelectedActivity.class);
////            startActivity(intent);
////        }
////        else if(v.getId() == R.id.class_ten_id){
////            Toast.makeText(this, "You clicked Class ten", Toast.LENGTH_SHORT).show();
////            Intent intent = new Intent(ClassSelectActivity.this, ClassSelectedActivity.class);
////            startActivity(intent);
////        }
////        else{
////            Toast.makeText(this, "Something Error Found, Please try again...", Toast.LENGTH_SHORT).show();
////        }
//
//    }

}