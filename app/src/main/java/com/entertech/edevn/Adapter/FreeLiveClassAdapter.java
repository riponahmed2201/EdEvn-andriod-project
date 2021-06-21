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

public class FreeLiveClassAdapter extends RecyclerView.Adapter<FreeLiveClassAdapter.ViewHolder> {

    private Context context;

    public FreeLiveClassAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shape_free_live_class,parent,false);
        FreeLiveClassAdapter.ViewHolder viewHolder = new FreeLiveClassAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FreeLiveClassAdapter.ViewHolder holder, int position) {
             holder.liveClassTeacherNameId.setText(Utils.teacherListModelArrayList.get(position).getTeacherName());
             Picasso.get().load(Utils.teacherListModelArrayList.get(position).getTeacherImage()).placeholder(R.drawable.business_image).into(holder.freeLiveClassImageId);
    }

    @Override
    public int getItemCount() {
        return Utils.freeLiveClassModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView freeLiveClassImageId;
        private final TextView liveClassTeacherNameId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            freeLiveClassImageId = itemView.findViewById(R.id.free_live_class_image_id);
            liveClassTeacherNameId = itemView.findViewById(R.id.live_class_teacher_name_id);
        }
    }
}
