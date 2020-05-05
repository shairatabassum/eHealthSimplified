package com.example.ehealthsimplified;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Edit_PatientProfile extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_patientprofile);

        //spinner (blood group)
        Spinner spinner = findViewById(R.id.upp_bloodgroup);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Edit_PatientProfile.this,
                R.array.bloodgroups, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Edit_PatientProfile.this);

        //spinner (gender)
        Spinner spinner2 = findViewById(R.id.upp_gender);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Edit_PatientProfile.this,
                R.array.gender, R.layout.spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Edit_PatientProfile.this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
