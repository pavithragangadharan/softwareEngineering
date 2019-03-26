package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Bookbus extends AppCompatActivity {
    ListView lv;
    TextView tvsrc, tvdst, tvdoj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookbus);
        lv = findViewById(R.id.lv);
        tvdoj = findViewById(R.id.tvdoj);
        tvdst = findViewById(R.id.tvdst);
        tvsrc = findViewById(R.id.tvsrc);
        Bundle bundle = getIntent().getExtras();
        String[] opname = {"Kesineni", "Morning star", "Orange", "SVR", "Five star"};
        String[] arrival = {"6am", "8am", "12pm", "4pm", "4am"};
        String[] dept = {"11pm", "10pm", "9pm", "8am", "11am"};
        String[] prices = {"900", "1100", "950", "800", "1200"};
        String[] seats = {"10", "27", "20", "12", "7"};
     busadapter adapter = new busadapter(this, opname, dept, prices, seats, arrival);
     lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String number = "8919138258";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(Bookbus.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);

            }
        });
        // Toast.makeText(this,bundle.getString("src"),Toast.LENGTH_SHORT).show();
        tvsrc.setText("Source is "+bundle.getString("src"));
        tvdst.setText("Destination is "+bundle.getString("dst"));
        tvdoj.setText("Date of Journey is "+bundle.getString("date"));
    }
}
