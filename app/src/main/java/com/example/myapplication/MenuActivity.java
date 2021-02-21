package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MenuActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private GpsFragment gpsFragment = new GpsFragment();
    private MapFragment mapFragment = new MapFragment();
    private BookmarkFragment bookmarkFragment = new BookmarkFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
}
