package com.example.dolphin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout containe;
    Toolbar toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        containe = findViewById(R.id.myContainer);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        loadFragment(new HomeFragment());



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.Home){
                        loadFragment(new HomeFragment());
                }
                if(id==R.id.MyProfile){
                        loadFragment(new MyProfileFragment());
                }
                if(id==R.id.Assignments){

                }
                if(id==R.id.PYQ){

                }
                if(id==R.id.guideline){

                }
                if(id==R.id.Setting){

                }
                if(id==R.id.Logout){

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return  true;

            }
        });



    }
    @Override
 public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        @SuppressLint("CommitTransaction") FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.myContainer,fragment);
        ft.commit();

    }
}