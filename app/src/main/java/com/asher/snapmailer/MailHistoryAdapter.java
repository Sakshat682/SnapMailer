package com.asher.snapmailer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MailHistoryAdapter extends RecyclerView.Adapter<MailHistoryAdapter.ViewHolder> {

    private List<MailHistoryModel> list;

    public MailHistoryAdapter(List<MailHistoryModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MailHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mail_history_item_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MailHistoryAdapter.ViewHolder holder, int position) {

        holder.setData(list.get(position).getImage(),
                list.get(position).getName(),
                list.get(position).getTime(),
                list.get(position).isIncoming
        );

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, typeIv;
        TextView nameTv, timeTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.profileImage);
            nameTv = itemView.findViewById(R.id.nameTv);
            timeTv = itemView.findViewById(R.id.timeTv);
            typeIv = itemView.findViewById(R.id.isIncomingImg);

        }

        public void setData(int image, String name, String time, boolean isIncoming) {
            imageView.setImageDrawable(itemView.getResources().getDrawable(image));
            nameTv.setText(name);
            timeTv.setText(time);
//            if(isIncoming){
//                typeIv.setImageDrawable(itemView.getResources(R.drawable.call_incoming));
//            }
//            else{
//
//            }

        }
    }
}

