package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class tourism extends AppCompatActivity {
ListView lv2;
    tour1 adapter1;

    String[] places={"Coimbatore to Tirupati","Chennai to Tirupati","Coimbatore to Trivandram","Vijayawada to Ooty","Hyderabad to Araku" };
    String[] price={"8000","9500","4200","6800","12000"};
    String[] max={"4","5","6","5","3"};
    String x2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);

        lv2= findViewById(R.id.listview8);

        x2=getIntent().getStringExtra("mobilenum");
        adapter1 = new tour1(tourism.this, places,price,max);
        lv2.setAdapter(adapter1);
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                Toast.makeText(getApplicationContext(),places[position],Toast.LENGTH_SHORT).show();
                Intent i= new Intent(getApplicationContext(),tourism1.class);
                String first = places[position].toString();
                String second = price[position].toString();
                String third = max[position].toString();
                i.putExtra("places",first );
                i.putExtra("prices",second );
                i.putExtra("maxi",third );
                i.putExtra("mobile2",x2);
                startActivity(i);


            }
        });

    }
}
