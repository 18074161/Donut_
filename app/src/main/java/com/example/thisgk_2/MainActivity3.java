package com.example.thisgk_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity implements OnClickListener{
    RecyclerView rcv_bag;
    CustomAdapterBagggg adt;
    TextView tvSub, tvTotal;
//    ArrayList<Donut> mDonuts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
//        mDonuts = new ArrayList<>();
        rcv_bag = findViewById(R.id.rcv_bag);
        tvSub = findViewById(R.id.tvSub);
        tvTotal = findViewById(R.id.tvTotal);
        tvSub.setText(MainActivity2.tong+"");
        tvTotal.setText(MainActivity2.tong+"");
        adt = new CustomAdapterBagggg(MainActivity2.arrayDonut,this);
        rcv_bag.setHasFixedSize(true);
        rcv_bag.setAdapter(adt);
        rcv_bag.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void itemClick(Donut donut) {


    }

    @Override
    public void imgbtnPlusClick(Donut donut, int position) {
        if(MainActivity2.arrayDonut.get(position).getSoLuong() != 1){
            MainActivity2.arrayDonut.get(position).setSoLuong(MainActivity2.arrayDonut.get(position).getSoLuong()-1);

            MainActivity2.tong = 0;
            for(Donut d:MainActivity2.arrayDonut){
                MainActivity2.tong+=d.getPrice()*d.getSoLuong();
            }
            tvSub.setText(MainActivity2.tong+"");
            tvTotal.setText(MainActivity2.tong+"");
            adt = new CustomAdapterBagggg(MainActivity2.arrayDonut,this);
            rcv_bag.setHasFixedSize(true);
            rcv_bag.setAdapter(adt);
            rcv_bag.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        }

    }

    @Override
    public void imgbtnMinlusClick(Donut donut, int position) {
        MainActivity2.arrayDonut.get(position).setSoLuong(MainActivity2.arrayDonut.get(position).getSoLuong()+1);

        MainActivity2.tong = 0;
        for(Donut d:MainActivity2.arrayDonut){
            MainActivity2.tong+=d.getPrice()*d.getSoLuong();
        }
        tvSub.setText(MainActivity2.tong+"");
        tvTotal.setText(MainActivity2.tong+"");
        adt = new CustomAdapterBagggg(MainActivity2.arrayDonut,this);
        rcv_bag.setHasFixedSize(true);
        rcv_bag.setAdapter(adt);
        rcv_bag.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void imgbtnAdd(Donut donut) {


    }
}