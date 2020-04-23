package com.example.ehealthsimplified;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class Appointment_doctor_adapter extends RecyclerView.Adapter<Appointment_doctor_adapter.appointment_doctor_ViewHolder>{
    private String[] patientnamelist, timelist, datelist, phonelist, paymentlist, statuslist;
    public Appointment_doctor_adapter(String[] patientnamelist, String[] timelist, String[] datelist, String[] phonelist, String[] paymentlist, String[] statuslist) {
        this.patientnamelist=patientnamelist;
        this.timelist=timelist;
        this.datelist=datelist;
        this.phonelist=phonelist;
        this.paymentlist=paymentlist;
        this.statuslist=statuslist;
    }

    @NonNull
    @Override
    public appointment_doctor_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.appointment_doctor_row, parent, false);
        return new appointment_doctor_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final appointment_doctor_ViewHolder holder, final int position) {
        holder.patientname.setText(patientnamelist[position]);
        holder.time.setText("Time: " + timelist[position]);
        holder.date.setText("Date: " + datelist[position]);
        holder.phone.setText("Mobile: " + phonelist[position]);
        holder.payment.setText("Payment Status: " + paymentlist[position]);
        //set status button
        if(statuslist[position]=="Completed") {
            holder.status.setText(statuslist[position]);
            holder.status.setBackgroundResource(R.drawable.greenbutton);
        }
        else if(statuslist[position]=="Pending") {
            holder.status.setText(statuslist[position]);
            holder.status.setBackgroundResource(R.drawable.redbutton);
        }
        else if(statuslist[position]=="Unreachable") {
            holder.status.setText(statuslist[position]);
            holder.status.setBackgroundResource(R.drawable.orangebutton);
        }
        //onclick status button
        holder.status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentstatus = (String) holder.status.getText();
                if(currentstatus == "Completed")
                {
                    // temporary code
                    holder.status.setText("Pending");
                    holder.status.setBackgroundResource(R.drawable.redbutton);
                }
                else if(currentstatus == "Pending")
                {
                    holder.status.setText("Unreachable");
                    holder.status.setBackgroundResource(R.drawable.orangebutton);
                }
                else if(currentstatus == "Unreachable")
                {
                    holder.status.setText("Completed");
                    holder.status.setBackgroundResource(R.drawable.greenbutton);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return patientnamelist.length;
    }

    public class appointment_doctor_ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profilepic;
        TextView patientname, time, date, phone, payment, status;

        public appointment_doctor_ViewHolder(View itemView) {
            super(itemView);
            profilepic = (CircleImageView) itemView.findViewById(R.id.ad_profilepic);
            patientname = (TextView) itemView.findViewById(R.id.ad_patientname);
            time = (TextView) itemView.findViewById(R.id.ad_time);
            date = (TextView) itemView.findViewById(R.id.ad_date);
            phone = (TextView) itemView.findViewById(R.id.ad_phone);
            payment = (TextView) itemView.findViewById(R.id.ad_payment);
            status = (TextView) itemView.findViewById(R.id.ad_status);
        }
    }
}
