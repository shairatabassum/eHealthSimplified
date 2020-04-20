package com.example.ehealthsimplified;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Appointment_patient_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment_patient_container);
        RecyclerView patientappointmentlist = (RecyclerView) findViewById(R.id.ap_recyclercontainer);
        patientappointmentlist.setLayoutManager(new LinearLayoutManager(Appointment_patient_main.this));
        String[] docnamelist = {"Dr. Tasmiah Shifa", "Dr. Krishna Mohan Sahu", "Dr. A.K.M Fazlul Haque", "Dr. Abdul Mannan Sarker", "Dr. Abu Sayeed Mohammad Iqbal"};
        String[] timelist = {"3:00 PM - 3:30 PM", "11:30 AM - 12:00 PM", "7:00 PM - 7:30 PM", "10:00 AM - 10:30 AM", "3:00 PM - 3:30 PM"};
        String[] datelist = {"22 April, 2020", "27 April, 2020", "3 May, 2020", "12 May, 2020", "20 May, 2020"};
        String[] locationlist = {"Plot 15, Road 71, Gulshan, United Hospital, Dhaka-1212", "Plot 15, Road 71, Gulshan, United Hospital, Dhaka-1212", "Plot 15, Road 71, Gulshan, United Hospital, Dhaka-1212", "Plot 15, Road 71, Gulshan, United Hospital, Dhaka-1212", "Plot 15, Road 71, Gulshan, United Hospital, Dhaka-1212"};
        patientappointmentlist.setAdapter(new Appointment_patient_adapter(docnamelist, timelist, datelist, locationlist));
    }
}
