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
                holder.freeLiveClassChapterNameId.setText(Utils.freeLiveClassModelArrayList.get(position).getCourseTitle());
                holder.free_live_class_subject_name_id.setText(Utils.freeLiveClassModelArrayList.get(position).getCategoryName());
//             holder.free_live_class_class_time_id.setText(Utils.freeLiveClassModelArrayList.get(position).getClassTime());
               // holder.free_live_class_duration_id.setText(Utils.freeLiveClassModelArrayList.get(position).getDuration());
                //holder.free_live_class_seat_left_id.setText(Utils.freeLiveClassModelArrayList.get(position).getTotalSeats());
             Picasso.get().load(Utils.freeLiveClassModelArrayList.get(position).getCoverImage()).placeholder(R.drawable.business_image).into(holder.freeLiveClassImageId);
    }

    @Override
    public int getItemCount() {
        return Utils.freeLiveClassModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView freeLiveClassImageId;
        private TextView free_live_class_subject_name_id,freeLiveClassChapterNameId, free_live_class_seat_left_id,free_live_class_class_time_id,free_live_class_duration_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            free_live_class_subject_name_id = itemView.findViewById(R.id.free_live_class_subject_name_id);
            freeLiveClassImageId = itemView.findViewById(R.id.free_live_class_image_id);
            freeLiveClassChapterNameId = itemView.findViewById(R.id.free_live_class_chapter_name_id);
            free_live_class_seat_left_id = itemView.findViewById(R.id.free_live_class_seat_left_id);
            free_live_class_class_time_id = itemView.findViewById(R.id.free_live_class_class_time_id);
            free_live_class_duration_id = itemView.findViewById(R.id.free_live_class_duration_id);

        }
    }
}
