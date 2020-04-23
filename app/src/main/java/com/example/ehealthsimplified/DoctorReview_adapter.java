package com.example.ehealthsimplified;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class DoctorReview_adapter extends RecyclerView.Adapter<DoctorReview_adapter.doctorreview_ViewHolder> {
    private String[] patientnamelist, datelist, reviewlist;
    private Integer[] ratinglist;
    public DoctorReview_adapter(String[] patientnamelist, String[] datelist, Integer[] ratinglist, String[] reviewlist) {
        this.patientnamelist = patientnamelist;
        this.datelist = datelist;
        this.ratinglist = ratinglist;
        this.reviewlist = reviewlist;
    }

    @NonNull
    @Override
    public doctorreview_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.doctorreview_row, parent, false);
        return new doctorreview_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull doctorreview_ViewHolder holder, int position) {
        holder.name.setText(patientnamelist[position]);
        holder.date.setText(datelist[position]);
        holder.rating.setRating(ratinglist[position]);
        holder.review.setText(reviewlist[position]);
    }

    @Override
    public int getItemCount() {
        return patientnamelist.length;
    }

    public class doctorreview_ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView pic;
        TextView name, date, review;
        RatingBar rating;
        public doctorreview_ViewHolder(View itemView) {
            super(itemView);
            pic = (CircleImageView) itemView.findViewById(R.id.dr_pic);
            name = (TextView) itemView.findViewById(R.id.dr_name);
            date = (TextView) itemView.findViewById(R.id.dr_date);
            rating = (RatingBar) itemView.findViewById(R.id.dr_ratingbar);
            review = (TextView) itemView.findViewById(R.id.dr_review);
        }
    }
}
