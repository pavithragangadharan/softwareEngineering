package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class hotelbilling extends AppCompatActivity {

    TextView t1,t2,t3;
    EditText e4,e5;
    String x,y,z;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelbilling);


        t1=findViewById(R.id.textView60);
        t2=findViewById(R.id.textView62);
        t3=findViewById(R.id.textView67);
        e4=findViewById(R.id.editText16);
        e5=findViewById(R.id.editText18);
        b1=findViewById(R.id.button9);


        x=getIntent().getStringExtra("hotelname");
        y=getIntent().getStringExtra("cost");
        z=getIntent().getStringExtra("place");

        t1.setText(z);
        t2.setText(x);
        t3.setText(y);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });



    }
}
