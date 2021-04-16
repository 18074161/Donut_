package com.example.thisgk_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ImageView imgDonutDt;
    TextView tvNameDt, tvPriceDt,tvDesDt,tvSoDt;
    Button btn_addtocart;
    Donut mDonut;
    ImageButton imgbtn_plusDt,imgbtn_minusDt;
    static ArrayList<Donut> arrayDonut;
    static int tong;
    static{
        arrayDonut = new ArrayList<>();
        tong = 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imgDonutDt = findViewById(R.id.imgDonutDt);
        tvNameDt = findViewById(R.id.tvNameDt);
        tvPriceDt = findViewById(R.id.tvPriceDt);
        tvDesDt = findViewById(R.id.tvDesDt);
        tvSoDt = findViewById(R.id.tvSoDt);
        btn_addtocart = findViewById(R.id.btn_addtocart);
        imgbtn_plusDt = findViewById(R.id.imgbtn_minusDt);
        imgbtn_minusDt = findViewById(R.id.imgbtn_plusDt);
        Intent intent = getIntent();
        if (intent != null){
            mDonut = (Donut) intent.getSerializableExtra("key1");
            tvNameDt.setText(mDonut.getName());
            imgDonutDt.setImageResource(mDonut.getAnh());
            tvPriceDt.setText(mDonut.getPrice()+"");
            tvDesDt.setText(mDonut.getDes());
        }
        imgbtn_plusDt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDonut.setSoLuong(mDonut.getSoLuong()+1);
                tvSoDt.setText(mDonut.getSoLuong()+"");
            }
        });
        imgbtn_minusDt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDonut.getSoLuong() !=1){
                    mDonut.setSoLuong(mDonut.getSoLuong()-1);
                    tvSoDt.setText(mDonut.getSoLuong()+"");
                }

            }
        });
        btn_addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
                arrayDonut.add(mDonut);
                tong = 0;
                for(Donut d:arrayDonut){
                    tong+=d.getPrice()*d.getSoLuong();
                }
                startActivity(intent1);
            }
        });
    }

}