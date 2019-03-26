package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Busbooking extends AppCompatActivity {
TextView date1;
    ImageView image;
    AutoCompleteTextView auto1,auto2;
    Calendar cal;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busbooking);

        image = findViewById(R.id.imageView5);
        date1=findViewById(R.id.Date);
        auto1=findViewById(R.id.Source);
        auto2=findViewById(R.id.Destination);
         b1=findViewById(R.id.doj);
         b2=findViewById(R.id.Search);

        String[] places={"Mumbai","Chennai","Bangalore","Goa","Kolkata","Hyderabad","Delhi","Agra"};
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,places);
        auto1.setThreshold(0);
        auto2.setThreshold(0);
        auto1.setAdapter(adapter);
        auto2.setAdapter(adapter);
        date1.setText("4-3-2019");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(Busbooking.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        // String x=Integer.toString(i2)+"-"+Integer.toString(i1)+"-"+Integer.toString(i);

                        if(i>2019||((i==2019&&i2>=4&&i1>=3)))
                            date1.setText(Integer.toString(i2)+"-"+Integer.toString(i1)+"-"+Integer.toString(i));
                        else
                            Toast.makeText(Busbooking.this,"FUTURE DATE PLEASE SELECT", Toast.LENGTH_SHORT).show();

                    }
                },2019,3,4);
                datePickerDialog.show();
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x=auto1.getText().toString();
                auto1.setText(auto2.getText().toString());
                auto2.setText(x);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!auto1.getText().toString().isEmpty()&&!auto2.getText().toString().isEmpty()) {
                    Intent intent = new Intent(Busbooking.this, Bookbus.class);
                        intent.putExtra("src", auto1.getText().toString());
                        intent.putExtra("dst", auto2.getText().toString());
                        intent.putExtra("date", date1.getText().toString());
                        startActivity(intent);



                }
                else
                    Toast.makeText(Busbooking.this,"Fill all data",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    }

