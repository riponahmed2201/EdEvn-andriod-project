package com.entertech.edevn.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    }
}