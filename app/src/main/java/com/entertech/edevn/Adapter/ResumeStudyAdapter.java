package com.entertech.edevn.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.entertech.edevn.R;
import com.entertech.edevn.Utils.Utils;
import com.squareup.picasso.Picasso;

public class ResumeStudyAdapter extends RecyclerView.Adapter<ResumeStudyAdapter.ViewHolder> {

    private Context context;

    public ResumeStudyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shape_resume_study_class,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.resumeMathSubjectName.setText(Utils.resumeStudyInfoArrayList.get(position).getChapterName());
        holder.resumeMathSubjectDescription.setText(Utils.resumeStudyInfoArrayList.get(position).getChapterName());
        Picasso.get().load(Utils.resumeStudyInfoArrayList.get(position).getCoverImage()).placeholder(R.drawable.business_image).into(holder.resumeMathSubjectImage);
    }

    @Override
    public int getItemCount() {
        return Utils.resumeStudyInfoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView resumeMathSubjectImage;
        private TextView resumeMathSubjectName, resumeMathSubjectDescription, resumeMathSubjectLesson;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            resumeMathSubjectImage = itemView.findViewById(R.id.resume_math_subject_image);
            resumeMathSubjectName = itemView.findViewById(R.id.resume_math_subject_name);
            resumeMathSubjectDescription = itemView.findViewById(R.id.resume_math_subject_description);
            resumeMathSubjectLesson = itemView.findViewById(R.id.resume_math_subject_lesson);
        }
    }
}
