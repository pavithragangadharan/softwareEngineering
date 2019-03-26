package com.example.myapplication;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Payment extends AppCompatActivity {

    TextView textView1,textView2;
    SQLiteDatabase db;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        textView1=findViewById(R.id.textView17);
        textView2=findViewById(R.id.textView21);
        b1=findViewById(R.id.button4);
        db = openOrCreateDatabase("Payeasy", Context.MODE_PRIVATE, null);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadfragment(new SecondFragment());

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("SELECT * FROM paying", null);
                if (c.getCount() == 0) {
                    showMessage("Error", "No records found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (c.moveToNext()) {
                    buffer.append("card num: " + c.getString(0) + "\n");
                    buffer.append("expdate: " + c.getString(1) + "\n");
                    buffer.append("cvv: " + c.getString(2) + "\n\n");
                }
                showMessage("Recent payments", buffer.toString());
            }
        });

    }
    private void loadfragment(Fragment fragment) {

      android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
fragmentTransaction.commit();
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
