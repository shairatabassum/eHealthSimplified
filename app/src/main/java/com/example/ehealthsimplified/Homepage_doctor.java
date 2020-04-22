package com.example.ehealthsimplified;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

public class Homepage_doctor extends AppCompatActivity {

    private DrawerLayout doctor_navdrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_doctor_container);

        Toolbar toolbar = findViewById(R.id.toolbardoctor);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");

        doctor_navdrawer = findViewById(R.id.menu_doctor);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, doctor_navdrawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        doctor_navdrawer.addDrawerListener(toggle);
        toggle.syncState();
    }
}
