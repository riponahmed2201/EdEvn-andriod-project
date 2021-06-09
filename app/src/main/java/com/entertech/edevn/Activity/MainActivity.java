package com.entertech.edevn.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.entertech.edevn.Fragment.ExamFragment;
import com.entertech.edevn.Fragment.HomeFragment;
import com.entertech.edevn.Fragment.LiveClassFragment;
import com.entertech.edevn.Fragment.ProfileFragment;
import com.entertech.edevn.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private NavigationView drawerNavigationView;
    private DrawerLayout drawerLayout;
//    private ImageView drawerMenuId;

    private HomeFragment homeFragment;
    private ExamFragment examFragment;
    private LiveClassFragment liveClassFragment;
    private ProfileFragment profileFragment;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        frameLayout = findViewById(R.id.frame_layout);
//        drawerMenuId = findViewById(R.id.drawer_menu_id);
        toolbar = findViewById(R.id.toolbar);

        drawerNavigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        drawerMenuId.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,DrawerActivity.class);
//                startActivity(intent);
//            }
//        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater menuInflater = getMenuInflater();
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home_menu_bar,menu);
       // menuInflater.inflate(R.menu.home_menu_bar,menu);
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
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

//        else if (id == R.id.update_profile_menu_id)
//        {
//            Intent intent = new Intent(MainActivity.this, UpdateProfileActivity.class);
//            startActivity(intent);
//        }

//        else if (id == R.id.view_profile_menu_id)
//        {
//            Intent intent = new Intent(MainActivity.this, ViewProfileActivity.class);
//            startActivity(intent);
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}