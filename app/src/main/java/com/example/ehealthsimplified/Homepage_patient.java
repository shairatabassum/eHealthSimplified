package com.example.ehealthsimplified;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

public class Homepage_patient extends AppCompatActivity {

    private DrawerLayout patient_navdrawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_patient_container);

        Toolbar toolbar = findViewById(R.id.toolbarpatient);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");

        patient_navdrawer = findViewById(R.id.menu_patient);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, patient_navdrawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        patient_navdrawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(patient_navdrawer.isDrawerOpen(GravityCompat.START)){
            patient_navdrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
