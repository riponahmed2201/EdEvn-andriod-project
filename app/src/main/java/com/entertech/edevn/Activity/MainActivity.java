package com.entertech.edevn.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.entertech.edevn.Fragment.ExamFragment;
import com.entertech.edevn.Fragment.HomeFragment;
import com.entertech.edevn.Fragment.LiveClassFragment;
import com.entertech.edevn.Fragment.ProfileFragment;
import com.entertech.edevn.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private HomeFragment homeFragment;
    private ExamFragment examFragment;
    private LiveClassFragment liveClassFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        frameLayout = findViewById(R.id.frame_layout);

        homeFragment = new HomeFragment();
        examFragment = new ExamFragment();
        liveClassFragment = new LiveClassFragment();
        profileFragment = new ProfileFragment();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,homeFragment).commit();
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                if (item.getItemId() == R.id.home_bottom_navigation_id){
                    fragment = homeFragment;
                }
                if (item.getItemId() == R.id.live_class_bottom_navigation_id){
                    fragment = liveClassFragment;
                }
                if (item.getItemId() == R.id.exam_bottom_navigation_id){
                    fragment = examFragment;
                }
                if (item.getItemId() == R.id.profile_bottom_navigation_id){
                    fragment = profileFragment;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
                return true;
            }
        });
    }
}