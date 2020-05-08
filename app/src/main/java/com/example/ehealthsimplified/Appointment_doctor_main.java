package com.example.ehealthsimplified;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Appointment_doctor_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_doctor_container);
        RecyclerView doctorappointmentlist = (RecyclerView) findViewById(R.id.ad_recyclercontainer);
        doctorappointmentlist.setLayoutManager(new LinearLayoutManager(Appointment_doctor_main.this));
        String[] patientnamelist = {"Rahima Begum", "Karima Khatun", "Rabeya Jahan", "Samsun Nahar", "Firoza Begum"};
        String[] timelist = {"3:00 PM - 3:30 PM", "11:30 AM - 12:00 PM", "7:00 PM - 7:30 PM", "10:00 AM - 10:30 AM", "3:00 PM - 3:30 PM"};
        String[] datelist = {"22 April, 2020", "27 April, 2020", "3 May, 2020", "12 May, 2020", "20 May, 2020"};
        String[] phonelist = {"+8801711111111", "+8801722222222", "+8801733333333", "+8801744444444", "+8801755555555"};
        String[] paymentlist = {"Paid", "Paid", "Paid", "Paid", "Paid"};
        String[] statuslist = {"Completed", "Pending", "Unreachable", "Pending", "Pending"};
        doctorappointmentlist.setAdapter(new Appointment_doctor_adapter(patientnamelist, timelist, datelist, phonelist, paymentlist, statuslist));
    }

    @Override
    public void onBackPressed() {
        finish();
    }
    public void page_goback(View v) {
        finish();
    }
}
