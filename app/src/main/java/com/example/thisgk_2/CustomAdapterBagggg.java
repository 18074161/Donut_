package com.example.thisgk_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterBagggg extends RecyclerView.Adapter<CustomAdapterBagggg.ViewHolder> {
    ArrayList<Donut> mDonuts;
    OnClickListener listener;

    public CustomAdapterBagggg(ArrayList<Donut> donuts,OnClickListener listener) {
        mDonuts = donuts;

        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bag_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mDonuts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Donut mDonut;
        int position;
        ImageView imgDonutbag;
        ImageButton imgbtn_plusbag,imgbtn_minusbag;
        TextView tvNamebag, tvPricebag, tvDesbag,tvSobag;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDonutbag = itemView.findViewById(R.id.imgDonutbag);
            imgbtn_plusbag = itemView.findViewById(R.id.imgbtn_plusbag);
            imgbtn_minusbag = itemView.findViewById(R.id.imgbtn_minusbag);
            tvNamebag = itemView.findViewById(R.id.tvNamebag);
            tvPricebag = itemView.findViewById(R.id.tvPricebag);
            tvDesbag = itemView.findViewById(R.id.tvDesbag);
            tvSobag = itemView.findViewById(R.id.tvSobag);
            imgbtn_plusbag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.imgbtnPlusClick(mDonut,position);
                }
            });
            imgbtn_minusbag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.imgbtnMinlusClick(mDonut,position);
                }
            });

        }
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Donut donut = mDonuts.get(position);
        holder.position = position;
        holder.mDonut  = donut;
        holder.imgDonutbag.setImageResource(donut.getAnh());
        holder.tvPricebag.setText(donut.getPrice()+"");
        holder.tvNamebag.setText(donut.getName());
        holder.tvDesbag.setText(donut.getDes());
        holder.tvSobag.setText(donut.getSoLuong()+"");

    }

}
