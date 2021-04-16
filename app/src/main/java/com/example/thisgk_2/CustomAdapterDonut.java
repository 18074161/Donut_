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

public class CustomAdapterDonut extends RecyclerView.Adapter<CustomAdapterDonut.ViewHolder> {
    ArrayList<Donut> mDonuts;
    OnClickListener listener;

    public CustomAdapterDonut(ArrayList<Donut> donuts,OnClickListener listener) {
        this.mDonuts = donuts;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donut_item,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return mDonuts.size();
    }

    public void filterList(ArrayList<Donut> donuts) {
        mDonuts = donuts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Donut mDonut;
        ImageView imgDonut;
        TextView tvName, tvDes, tvPrice,tvSobag;
        ImageButton imgbtn_plus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDonut = itemView.findViewById(R.id.imgDonut);
            tvName = itemView.findViewById(R.id.tvName);
            tvDes = itemView.findViewById(R.id.tvDes);

            tvPrice = itemView.findViewById(R.id.tvPrice);
            imgbtn_plus = itemView.findViewById(R.id.imgbtn_plus);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemClick(mDonut);
                }
            });
            imgbtn_plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.imgbtnAdd(mDonut);
                }
            });

        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Donut donut = mDonuts.get(position);
        holder.mDonut = donut;
        holder.imgDonut.setImageResource(donut.getAnh());
        holder.tvPrice.setText(donut.getPrice()+"");
        holder.tvName.setText(donut.getName());
        holder.tvDes.setText(donut.getDes());



    }

}
