package com.example.ehealthsimplified;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class FindDoctor_main extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finddoctor_container);
        RecyclerView finddoctorlist = (RecyclerView) findViewById(R.id.fd_recyclercontainer);
        finddoctorlist.setLayoutManager(new LinearLayoutManager(FindDoctor_main.this));
        String[] docnamelist = {"Dr. Tasmiah Shifa", "Dr. Krishna Mohan Sahu", "Dr. A.K.M Fazlul Haque", "Dr. Abdul Mannan Sarker", "Dr. Abu Sayeed Mohammad Iqbal"};
        Integer[] ratinglist = {5,4,3,2,1};
        String[] educationlist = {"MBBS", "MBBS, MD (Med.), DNB (Nephrology), DM (Nephrology), Fellowship (Nephrology) Canada", "MBBS, FRCS (UK)", "MBBS, DEM (DU), MD (Endocrinology)", "MBBS, FCPS, MD, Fellow (Singapore), Neonatal Training in Singapore"};
        String[] locationlist = {"Plot 15, Road 71, Gulshan, United Hospital, Dhaka-1212", "Plot 15, Road 71, Gulshan, United Hospital, Dhaka-1212", "Plot 15, Road 71, Gulshan, United Hospital, Dhaka-1212", "Plot 15, Road 71, Gulshan, United Hospital, Dhaka-1212", "Plot 15, Road 71, Gulshan, United Hospital, Dhaka-1212"};
        finddoctorlist.setAdapter(new FindDoctor_adapter(docnamelist, ratinglist, educationlist, locationlist));

        //filter dialog
        ImageView filterbutton = findViewById(R.id.fd_filter);
        filterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFilterDialog();
            }
        });
    }

    public void showFilterDialog() {
        LayoutInflater inflater = LayoutInflater.from(FindDoctor_main.this);
        View view = inflater.inflate(R.layout.finddoctor_filter, null);

        final Button applybtn = view.findViewById(R.id.fd_filter_apply_btn);
        Button resetbtn = view.findViewById(R.id.fd_filter_reset_btn);
        applybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        AlertDialog alertDialog = new AlertDialog.Builder(FindDoctor_main.this)
                .setView(view)
                .create();
        alertDialog.show();

        //spinner - specialists
        Spinner spinnerspecialist = view.findViewById(R.id.fd_filter_specialist);
        ArrayAdapter<CharSequence> adapterspecialist = ArrayAdapter.createFromResource(FindDoctor_main.this,
                R.array.specialities, R.layout.spinner_item);
        adapterspecialist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerspecialist.setAdapter(adapterspecialist);
        spinnerspecialist.setOnItemSelectedListener(FindDoctor_main.this);

        //spinner - hospitals and medical centers
        Spinner spinnerorg = view.findViewById(R.id.fd_filter_org);
        ArrayAdapter<CharSequence> adapterorg = ArrayAdapter.createFromResource(FindDoctor_main.this,
                R.array.hospitals, R.layout.spinner_item);
        adapterorg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerorg.setAdapter(adapterorg);
        spinnerorg.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) FindDoctor_main.this);

        //spinner - location
        Spinner spinnerlocation = view.findViewById(R.id.fd_filter_location);
        ArrayAdapter<CharSequence> adapterlocation = ArrayAdapter.createFromResource(FindDoctor_main.this,
                R.array.locations, R.layout.spinner_item);
        adapterlocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerlocation.setAdapter(adapterlocation);
        spinnerlocation.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) FindDoctor_main.this);

        //spinner - fees
        Spinner spinnerfees = view.findViewById(R.id.fd_filter_fees);
        ArrayAdapter<CharSequence> adapterfees = ArrayAdapter.createFromResource(FindDoctor_main.this,
                R.array.fees, R.layout.spinner_item);
        adapterfees.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerfees.setAdapter(adapterfees);
        spinnerfees.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) FindDoctor_main.this);

        //spinner - rating
        Spinner spinnerrating = view.findViewById(R.id.fd_filter_rating);
        ArrayAdapter<CharSequence> adapterrating = ArrayAdapter.createFromResource(FindDoctor_main.this,
                R.array.ratings, R.layout.spinner_item);
        adapterrating.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerrating.setAdapter(adapterrating);
        spinnerrating.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) FindDoctor_main.this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onBackPressed() {
        finish();
    }
    public void page_goback(View v) {
        finish();
    }
}
