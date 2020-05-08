package com.example.ehealthsimplified;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menuitems, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_patient_profile) {
            Intent intent = new Intent(Homepage_doctor.this, DoctorProfile.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void page_appointment(View view) {
        Intent intent = new Intent(Homepage_doctor.this, Appointment_doctor_main.class);
        startActivity(intent);
    }

    public void page_reviews(View view) {
        Intent intent = new Intent(Homepage_doctor.this, DoctorReview_main.class);
        startActivity(intent);
    }

    public void page_doctorslist(View view) {
        Intent intent = new Intent(Homepage_doctor.this, FindDoctor_main.class);
        startActivity(intent);
    }

    public void page_profile(View view) {
        Intent intent = new Intent(Homepage_doctor.this, FindDoctor_main.class);
        startActivity(intent);
    }
}
