package com.asher.snapmailer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private List<ScheduleModel> list;

    public ScheduleAdapter(List<ScheduleModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.ViewHolder holder, int position) {

        holder.setData(list.get(position).getImage(),
                list.get(position).getName(),
                list.get(position).getTime(),
                list.get(position).getDateTime()
        );


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nameTv, timeTv, DateTimeTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.profileImage);
            nameTv = itemView.findViewById(R.id.nameTv);
            timeTv = itemView.findViewById(R.id.chatTime);
            DateTimeTv = itemView.findViewById(R.id.timeTv);

        }

        public void setData(int image, String name, String time, String lastMsg) {
            imageView.setImageDrawable(itemView.getResources().getDrawable(image));
            nameTv.setText(name);
            DateTimeTv.setText(lastMsg);
            timeTv.setText(time);
        }
    }
}
