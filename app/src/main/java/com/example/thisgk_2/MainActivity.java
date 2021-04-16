package com.example.thisgk_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener, TextWatcher {
    RecyclerView rcv_donut;
    CustomAdapterDonut adt;
    ArrayList<Donut> mDonuts;
    ImageButton imgbtn_plus;
    EditText edSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDonuts = new ArrayList<>();
        rcv_donut = findViewById(R.id.rec_donut);
        edSearch = findViewById(R.id.edSearch);


        edSearch.addTextChangedListener(this);

        mDonuts.add(new Donut(R.drawable.donut_red,"Red donut","dakdbakbdfww",10,R.drawable.vector_donut,1));
        mDonuts.add(new Donut(R.drawable.donut_yellow,"best donut yellow","dakdbakbdfww",20,R.drawable.vector_donut,1));
        mDonuts.add(new Donut(R.drawable.green_donut,"Donut 2","dakdbakbdfww",30,R.drawable.vector_donut,1));
        mDonuts.add(new Donut(R.drawable.tasty_donut,"Delicious Donutt","dakdbakbdfww",40,R.drawable.vector_donut,1));
        mDonuts.add(new Donut(R.drawable.donut_red,"Donut 3","dakdbakbdfww",50,R.drawable.vector_donut,1));

        adt = new CustomAdapterDonut(mDonuts,this);
        rcv_donut.setHasFixedSize(true);
        rcv_donut.setAdapter(adt);
        rcv_donut.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void itemClick(Donut donut) {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("key1",donut);
        startActivity(intent);
    }

    @Override
    public void imgbtnPlusClick(Donut donut, int position) {


    }

    @Override
    public void imgbtnMinlusClick(Donut donut, int position) {

    }

    @Override
    public void imgbtnAdd(Donut donut) {
        Intent intent = new Intent(MainActivity.this,MainActivity3.class);
        MainActivity2.arrayDonut.add(donut);
        startActivity(intent);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        filter(s.toString());
    }

    private void filter(String toString) {
        ArrayList<Donut> donuts;
        donuts = new ArrayList<>();
        for (Donut d:mDonuts){
            if (d.getName().toLowerCase().contains(toString.toLowerCase())){
                donuts.add(d);
            }
        }
        adt.filterList(donuts);
    }
}