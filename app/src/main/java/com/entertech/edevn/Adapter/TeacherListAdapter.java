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

public class TeacherListAdapter extends RecyclerView.Adapter<TeacherListAdapter.ViewHolder> {

    private Context context;

    public TeacherListAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shape_teacher_list,parent,false);
        TeacherListAdapter.ViewHolder viewHolder = new TeacherListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherListAdapter.ViewHolder holder, int position) {
             holder.liveClassTeacherNameId.setText(Utils.teacherListModelArrayList.get(position).getTeacherName());
             Picasso.get().load(Utils.teacherListModelArrayList.get(position).getTeacherImage()).placeholder(R.drawable.business_image).into(holder.liveClassTeacherImageId);
    }

    @Override
    public int getItemCount() {
        return Utils.teacherListModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView liveClassTeacherImageId;
        private final TextView liveClassTeacherNameId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            liveClassTeacherImageId = itemView.findViewById(R.id.live_class_teacher_img_id);
            liveClassTeacherNameId = itemView.findViewById(R.id.live_class_teacher_name_id);
        }
    }
}
