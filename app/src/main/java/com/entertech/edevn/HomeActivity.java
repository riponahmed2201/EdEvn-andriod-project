package com.entertech.edevn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private CardView liveClassDetailsId;
    private LinearLayout homeMathSubId;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        liveClassDetailsId = findViewById(R.id.live_class_details_Id);
        homeMathSubId = findViewById(R.id.home_math_sub_Id);
        toolbar = findViewById(R.id.home_menu_tool_bar_id);

        setSupportActionBar(toolbar);

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

    //menu bar all code here
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        MenuInflater menuInflater = getMenuInflater();

        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home_menu_bar,menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.share_menu_id)
        {
            Toast.makeText(this, "You Click share menu", Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.logout_menu_id)
        {
            Toast.makeText(this, "Logout successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        else if (id == R.id.update_profile_menu_id)
        {
            Intent intent = new Intent(HomeActivity.this, UpdateProfileActivity.class);
            startActivity(intent);
        }

        else if (id == R.id.view_profile_menu_id)
        {
            Intent intent = new Intent(HomeActivity.this, ViewProfileActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}