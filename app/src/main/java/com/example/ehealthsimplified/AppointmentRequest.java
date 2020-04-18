package com.example.ehealthsimplified;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AppointmentRequest extends AppCompatActivity {

    Button reqapp_btn;
    Calendar calendar;
    DatePickerDialog datepickdialog;
    int day, month, year;
    String monthname, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorprofile);

        reqapp_btn = (Button) findViewById(R.id.dp_reqapp_btn);
        reqapp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                day = calendar.get(Calendar.DAY_OF_MONTH);
                SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
                monthname = month_date.format(calendar.getTime());
                month = calendar.get(Calendar.MONTH);
                year = calendar.get(Calendar.YEAR);

                datepickdialog = new DatePickerDialog(AppointmentRequest.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        timepickdialog();
                    }
                }, year, month, day);
                datepickdialog.show();
            }
        });
    }

    public void timepickdialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AppointmentRequest.this);
        final String[] listOfTime = {"9:00 AM - 9:30 AM", "9:30 AM - 10:00 AM", "10:00 AM - 10:30 AM", "10:30 AM - 11:00 AM", "11:00 AM - 11:30 AM", "11:30 AM - 12:00 PM", "3:00 PM - 3:30 PM", "3:30 PM - 4:00 PM", "4:00 PM - 4:30 PM", "4:30 PM - 5:00PM"};

        new AlertDialog.Builder(AppointmentRequest.this)
                .setTitle("Available Slot")
                .setSingleChoiceItems(listOfTime, 0, null)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                        int selectedPosition = ((AlertDialog)dialog).getListView().getCheckedItemPosition();
                        time = listOfTime[selectedPosition];
                        appointmentconfirmdialog();
                    }
                })
                .show();
    }

    public void appointmentconfirmdialog() {
        new AlertDialog.Builder(AppointmentRequest.this)
                .setTitle("Appointment Confirmation")
                .setMessage("Your request for appointment at " + day + " " + monthname + " " + time + " has been approved. Doctor's office will consult the appointment.")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }
}
