package com.example.ehealthsimplified;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class DoctorProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorprofile);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
    public void page_goback(View v) {
        finish();
    }
}
