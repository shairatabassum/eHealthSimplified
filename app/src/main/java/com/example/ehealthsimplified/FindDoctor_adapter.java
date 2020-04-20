package com.example.ehealthsimplified;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class FindDoctor_adapter extends RecyclerView.Adapter<FindDoctor_adapter.FindDoctor_ViewHolder> {
    private String[] docnamelist, educationlist, locationlist;
    public FindDoctor_adapter(String[] docnamelist, String[] educationlist, String[] locationlist) {
        this.docnamelist=docnamelist;
        this.educationlist=educationlist;
        this.locationlist=locationlist;
    }

    @Override
    public FindDoctor_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.finddoctor_row, parent, false);
        return new FindDoctor_adapter.FindDoctor_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FindDoctor_ViewHolder holder, int position) {
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
        holder.education.setText(educationlist[position]);
        holder.location.setText(locationlist[position]);
    }

    @Override
    public int getItemCount() {
        return docnamelist.length;
    }

    public class FindDoctor_ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView profilepic;
        TextView docname, education, location;
        public FindDoctor_ViewHolder(View itemView) {
            super(itemView);
            profilepic = (de.hdodenhof.circleimageview.CircleImageView) itemView.findViewById(R.id.fd_profilepic);
            docname = (TextView) itemView.findViewById(R.id.fd_docname);
            education = (TextView) itemView.findViewById(R.id.fd_education);
            location = (TextView) itemView.findViewById(R.id.fd_location);
        }
    }
}
