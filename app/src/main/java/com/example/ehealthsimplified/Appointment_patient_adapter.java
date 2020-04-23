package com.example.ehealthsimplified;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class Appointment_patient_adapter extends RecyclerView.Adapter<Appointment_patient_adapter.appointment_patient_ViewHolder> {

    private String[] docnamelist, timelist, datelist, locationlist;
    public Appointment_patient_adapter(String[] docnamelist, String[] timelist, String[] datelist, String[] locationlist) {
        this.docnamelist=docnamelist;
        this.timelist=timelist;
        this.datelist=datelist;
        this.locationlist=locationlist;
    }

    @Override
    public appointment_patient_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.appointment_patient_row, parent, false);
        return new appointment_patient_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull appointment_patient_ViewHolder holder, int position) {
        //temporary hard code for doctor image
        if(position==0)
            holder.profilepic.setImageResource(R.drawable.doctor1);
        else if(position==1)
            holder.profilepic.setImageResource(R.drawable.doctor2);
        else if(position==2)
            holder.profilepic.setImageResource(R.drawable.doctor3);
        else if(position==3)
            holder.profilepic.setImageResource(R.drawable.doctor4);
        else if(position==4)
            holder.profilepic.setImageResource(R.drawable.doctor5);

        holder.docname.setText(docnamelist[position]);
        holder.time.setText("Appointment: " + timelist[position] + " " + datelist[position]);
        holder.location.setText(locationlist[position]);
    }

    @Override
    public int getItemCount() {
        return docnamelist.length;
    }

    public class appointment_patient_ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView profilepic;
        TextView docname, time, location;
        public appointment_patient_ViewHolder(View itemView) {
            super(itemView);
            profilepic = (CircleImageView) itemView.findViewById(R.id.ap_profilepic);
            docname = (TextView) itemView.findViewById(R.id.ap_docname);
            time = (TextView) itemView.findViewById(R.id.ap_time);
            location = (TextView) itemView.findViewById(R.id.ap_location);

        }
    }
}
