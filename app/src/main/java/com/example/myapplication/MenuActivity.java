package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private GpsFragment gpsFragment = new GpsFragment();
    private MapFragment mapFragment = new MapFragment();
    private BookmarkFragment bookmarkFragment = new BookmarkFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, gpsFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction1 = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.gpsItem:
                        transaction.replace(R.id.frameLayout, gpsFragment).commitAllowingStateLoss();
                        break;
                    case R.id.mapItem:
                        transaction.replace(R.id.frameLayout, mapFragment).commitAllowingStateLoss();
                        break;
                    case R.id.bookmarkItem:
                        transaction.replace(R.id.frameLayout, bookmarkFragment).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });
    }
}
