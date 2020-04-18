package com.example.ehealthsimplified;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.app.DialogFragment;
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

import org.w3c.dom.Text;

public class Registration_Doctor extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

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
        setContentView(R.layout.registration_doctor);

        //add academic records
        TextView txtacademic = (TextView) findViewById(R.id.rd_addacademic);
        txtacademic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAcademicFields();
            }
        });

        //add affilication records
        TextView txtaffiliation = (TextView) findViewById(R.id.rd_addaffiliation);
        txtaffiliation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addAffiliationFields();
            }
        });

        //spinner (list of hospital)
        Spinner spinner = findViewById(R.id.rd_currentorg);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Registration_Doctor.this,
                R.array.hospitals, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Registration_Doctor.this);

        //time picker (visiting hour)
        txtFrom = (EditText) findViewById(R.id.rd_vh_from);
        txtFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(Registration_Doctor.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) { amPm = "PM"; } else { amPm = "AM"; }
                        txtFrom.setText(String.format("%02d : %02d ", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });
        txtTo = (EditText) findViewById(R.id.rd_vh_to);
        txtTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(Registration_Doctor.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) { amPm = "PM"; hourOfDay-=12; } else { amPm = "AM"; }
                        txtTo.setText(String.format("%02d : %02d ", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });
    }


    public void addAcademicFields() {
        LinearLayout academiclayout = (LinearLayout) findViewById(R.id.rd_academicrecord);
        LinearLayout.LayoutParams layoutmargin = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutmargin.setMargins(50, 70, 50, 0);
        LinearLayout.LayoutParams layoutmargin2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutmargin2.setMargins(50, 20, 50, 0);

        newdegree = new EditText(Registration_Doctor.this);
        newdegree.setHint("Degree");
        newdegree.setPadding(40,30,40,30);
        newdegree.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newdegree.setLayoutParams(layoutmargin);

        newinstitute = new EditText(Registration_Doctor.this);
        newinstitute.setHint("Name of the institute");
        newinstitute.setPadding(40,30,40,30);
        newinstitute.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newinstitute.setLayoutParams(layoutmargin2);

        newcountry = new EditText(Registration_Doctor.this);
        newcountry.setHint("Country");
        newcountry.setPadding(40,30,40,30);
        newcountry.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newcountry.setLayoutParams(layoutmargin2);

        academiclayout.addView(newdegree);
        academiclayout.addView(newinstitute);
        academiclayout.addView(newcountry);
    }

    public void addAffiliationFields() {
        LinearLayout affiliationlayout = (LinearLayout) findViewById(R.id.rd_affiliationrecord);
        LinearLayout.LayoutParams layoutmargin3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutmargin3.setMargins(50, 70, 50, 0);
        LinearLayout.LayoutParams layoutmargin4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutmargin4.setMargins(50, 20, 50, 0);

        newposition = new EditText(Registration_Doctor.this);
        newposition.setHint("Position");
        newposition.setPadding(40,30,40,30);
        newposition.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newposition.setLayoutParams(layoutmargin3);

        neworganization = new EditText(Registration_Doctor.this);
        neworganization.setHint("Name of the organization");
        neworganization.setPadding(40,30,40,30);
        neworganization.setBackgroundColor(Color.parseColor("#e5e5e5"));
        neworganization.setLayoutParams(layoutmargin4);

        newcity = new EditText(Registration_Doctor.this);
        newcity.setHint("City");
        newcity.setPadding(40,30,40,30);
        newcity.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newcity.setLayoutParams(layoutmargin4);

        newcountry2 = new EditText(Registration_Doctor.this);
        newcountry2.setHint("Country");
        newcountry2.setPadding(40,30,40,30);
        newcountry2.setBackgroundColor(Color.parseColor("#e5e5e5"));
        newcountry2.setLayoutParams(layoutmargin4);

        affiliationlayout.addView(newposition);
        affiliationlayout.addView(neworganization);
        affiliationlayout.addView(newcity);
        affiliationlayout.addView(newcountry2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        // write required code for spinner
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //write required code for spinner
    }
}
