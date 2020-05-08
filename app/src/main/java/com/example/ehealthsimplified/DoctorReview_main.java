package com.example.ehealthsimplified;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DoctorReview_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorreview_container);
        RecyclerView doctorreview = (RecyclerView) findViewById(R.id.dr_recyclercontainer);
        doctorreview.setLayoutManager(new LinearLayoutManager(DoctorReview_main.this));
        String[] patientnamelist = {"Rahima Begum", "Karima Khatun", "Rabeya Jahan", "Samsun Nahar", "Firoza Begum"};
        String[] datelist = {"22 April, 2020", "27 April, 2020", "3 May, 2020", "12 May, 2020", "20 May, 2020"};
        Integer[] ratinglist = {5, 4, 5, 3, 3};
        String[] reviewlist = {"He explains exactly what is wrong and how we are going to repair. I sincerely trust him, his medical knowledge and his judgment. The entire staff is friendly and makes you feel at ease even through some not-so-easy time.",
        "valo daktar", "I've never had better or more personal care from a healthcare team.", "Good doctor", "He is good"};
        doctorreview.setAdapter(new DoctorReview_adapter(patientnamelist, datelist, ratinglist, reviewlist));

        //write code here (to hide new post icon when logged in as doctors)

        //new post alert box (if logged in as patient)
        ImageView newpostbutton = findViewById(R.id.dr_newreview);
        newpostbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNewPostDialog();
            }
        });
    }

    public void showNewPostDialog() {
        LayoutInflater inflater = LayoutInflater.from(DoctorReview_main.this);
        View view = inflater.inflate(R.layout.doctorreview_newpost, null);

        Button submitbtn = view.findViewById(R.id.dr_np_btn);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        AlertDialog alertDialog = new AlertDialog.Builder(DoctorReview_main.this)
                .setView(view)
                .create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
    public void page_goback(View v) {
        finish();
    }
}
