package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Transport extends AppCompatActivity {
    private ListView lv;

    transportadapter lAdapter;
    private int[] images = {R.drawable.flight,R.drawable.bus,R.drawable.train};
    private String means[] = {"Flights", "Buses", "Trains"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        lv=findViewById(R.id.listView);

        lAdapter = new transportadapter(Transport.this, means, images);

        lv.setAdapter(lAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(Transport.this, means[i], Toast.LENGTH_SHORT).show();

                if(means[i].equals("Flights")){


                }
               else if(means[i].equals("Buses")){
                    Intent intent = new Intent(getApplicationContext(),Busbooking.class);
                    startActivity(intent);

                }
                else if(means[i].equals("Trains")){

                }

            }
        });

    }
}
