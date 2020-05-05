package com.example.ehealthsimplified;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Edit_DoctorProfile extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText newdegree, newinstitute, newcountry;
    EditText newposition, neworganization, newcity, newcountry2;
    EditText txtFrom, txtTo;
    String amPm;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_doctorprofile);

        //spinner (physician category)
        Spinner spinner = findViewById(R.id.udp_category);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Edit_DoctorProfile.this,
                R.array.specialities, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Edit_DoctorProfile.this);

        //add academic records
        TextView txtacademic = (TextView) findViewById(R.id.udp_addacademic);
        txtacademic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAcademicFields();
            }
        });

        //time picker (visiting hour)
        txtFrom = (EditText) findViewById(R.id.udp_vh_from);
        txtFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(Edit_DoctorProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) { amPm = "PM"; hourOfDay-=12; } else { amPm = "AM"; }
                        txtFrom.setText(String.format("%02d : %02d ", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });
        txtTo = (EditText) findViewById(R.id.udp_vh_to);
        txtTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(Edit_DoctorProfile.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) { amPm = "PM"; hourOfDay-=12; } else { amPm = "AM"; }
                        txtTo.setText(String.format("%02d : %02d ", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });

        //add affilication records
        TextView txtaffiliation = (TextView) findViewById(R.id.udp_addaffiliation);
        txtaffiliation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAffiliationFields();
            }
        });
    }

    public void addAcademicFields() {
        LinearLayout academiclayout = (LinearLayout) findViewById(R.id.udp_academicrecord);
        LinearLayout.LayoutParams layoutmargin = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutmargin.setMargins(60, 40, 60, 0);
        LinearLayout.LayoutParams layoutmargin2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutmargin2.setMargins(60, 15, 60, 0);

        newdegree = new EditText(Edit_DoctorProfile.this);
        newdegree.setHint("Degree");
        newdegree.setTextSize(13);
        newdegree.setTextColor(getResources().getColor(R.color.darkgray3));
        newdegree.setPadding(25,20,40,20);
        newdegree.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newdegree.setLayoutParams(layoutmargin);

        newinstitute = new EditText(Edit_DoctorProfile.this);
        newinstitute.setHint("Name of the institute");
        newinstitute.setTextSize(13);
        newinstitute.setTextColor(getResources().getColor(R.color.darkgray3));
        newinstitute.setPadding(25,20,40,20);
        newinstitute.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newinstitute.setLayoutParams(layoutmargin2);

        newcountry = new EditText(Edit_DoctorProfile.this);
        newcountry.setHint("Country");
        newcountry.setTextSize(13);
        newcountry.setTextColor(getResources().getColor(R.color.darkgray3));
        newcountry.setPadding(25,20,40,20);
        newcountry.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newcountry.setLayoutParams(layoutmargin2);

        academiclayout.addView(newdegree);
        academiclayout.addView(newinstitute);
        academiclayout.addView(newcountry);
    }

    public void addAffiliationFields() {
        LinearLayout affiliationlayout = (LinearLayout) findViewById(R.id.udp_affiliationrecord);
        LinearLayout.LayoutParams layoutmargin3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutmargin3.setMargins(60, 40, 60, 0);
        LinearLayout.LayoutParams layoutmargin4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutmargin4.setMargins(60, 15, 60, 0);

        newposition = new EditText(Edit_DoctorProfile.this);
        newposition.setHint("Position");
        newposition.setTextSize(13);
        newposition.setTextColor(getResources().getColor(R.color.darkgray3));
        newposition.setPadding(25,20,40,20);
        newposition.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newposition.setLayoutParams(layoutmargin3);

        neworganization = new EditText(Edit_DoctorProfile.this);
        neworganization.setHint("Name of the organization");
        neworganization.setTextSize(13);
        neworganization.setTextColor(getResources().getColor(R.color.darkgray3));
        neworganization.setPadding(25,20,40,20);
        neworganization.setBackgroundColor(Color.parseColor("#e5e5e5"));
        neworganization.setLayoutParams(layoutmargin4);

        newcity = new EditText(Edit_DoctorProfile.this);
        newcity.setHint("City");
        newcity.setTextSize(13);
        newcity.setTextColor(getResources().getColor(R.color.darkgray3));
        newcity.setPadding(25,20,40,20);
        newcity.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newcity.setLayoutParams(layoutmargin4);

        newcountry2 = new EditText(Edit_DoctorProfile.this);
        newcountry2.setHint("Country");
        newcountry2.setTextSize(13);
        newcountry2.setTextColor(getResources().getColor(R.color.darkgray3));
        newcountry2.setPadding(25,20,40,20);
        newcountry2.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newcountry2.setLayoutParams(layoutmargin4);

        affiliationlayout.addView(newposition);
        affiliationlayout.addView(neworganization);
        affiliationlayout.addView(newcity);
        affiliationlayout.addView(newcountry2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
