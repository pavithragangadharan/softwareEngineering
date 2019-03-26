package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Hotel extends AppCompatActivity  {

ListView lv1;
AutoCompleteTextView auto;
Button b3;
    hotel1 adapter1,adapter2,adapter3;
String[] places = {"Chennai","Hyderbad","Delhi","Mumbai"};
int[] images1={R.drawable.che1,R.drawable.che2,R.drawable.che3};
String[]hotels1={"Clarion Hotel President","Radisson Blu Hotel Chennai City Centre","Hyatt Regency Chennai"};
String []prices1={"3704","7800","5237"};
    int[] images2={R.drawable.hyd1,R.drawable.hyd2,R.drawable.hyd3};
    String[]hotels2={"The Park","Hyderabad Marriott Hotel & Convention Centre","Park Hyatt Hyderabad"};
    String []prices2={"4800","6134","3237"};
    int[] images3={R.drawable.mum1,R.drawable.mum2,R.drawable.mum3};
    String[]hotels3={"Holiday Inn Mumbai International Airport","Ibis Mumbai Airport","VITS Hotel"};
    String []prices3={"3400","6850","4200"};
String check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        lv1 = findViewById(R.id.listview5);
        b3=findViewById(R.id.button6);
        auto=findViewById(R.id.autoCompleteTextView);


        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,places);
        auto.setThreshold(2);
        auto.setAdapter(adapter);

b3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        check=auto.getText().toString();

        if(check.equals("Chennai")||check.equals("chennai")){
            adapter1 = new hotel1(Hotel.this, hotels1,prices1,images1);
            lv1.setAdapter(adapter1);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id)
                {
                    Toast.makeText(getApplicationContext(),hotels1[position],Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(getApplicationContext(),hotelbilling.class);
                    i.putExtra("hotelname",hotels1[position]);
                    i.putExtra("cost",prices1[position]);
                    i.putExtra("place",check);
                    startActivity(i);


                }
            });

        }
        if(check.equals("Hyderbad")||check.equals("hyderbad")){
            adapter2 = new hotel1(Hotel.this, hotels2,prices2,images2);
            lv1.setAdapter(adapter2);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id)
                {
                    Toast.makeText(getApplicationContext(),hotels2[position],Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(getApplicationContext(),hotelbilling.class);
                    i.putExtra("hotelname",hotels2[position]);
                    i.putExtra("cost",prices2[position]);
                    i.putExtra("place",check);
                    startActivity(i);


                }
            });
        }
        if(check.equals("Mumbai")||check.equals("mumbai")){
            adapter3 = new hotel1(Hotel.this, hotels3,prices3,images3);
            lv1.setAdapter(adapter3);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id)
                {
                    Toast.makeText(getApplicationContext(),hotels3[position],Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(getApplicationContext(),hotelbilling.class);
                    i.putExtra("hotelname",hotels3[position]);
                    i.putExtra("cost",prices3[position]);
                    i.putExtra("place",check);
                    startActivity(i);


                }
            });
        }
    }
});


    }
}
