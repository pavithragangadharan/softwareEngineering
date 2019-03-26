package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class tourism1 extends AppCompatActivity {
TextView t1,t2;
EditText e1;
Button b1;

    String a,b,c;
    int total=0,total1=0;
    String mobile;
    SQLiteDatabase db;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism1);
        db = openOrCreateDatabase("Payeasy", Context.MODE_PRIVATE, null);

        t1=findViewById(R.id.textView55);
        t2=findViewById(R.id.textView58);
        e1=findViewById(R.id.editText13);
        b1=findViewById(R.id.button8);

        a=getIntent().getStringExtra("places");
        b=getIntent().getStringExtra("prices");
        c=getIntent().getStringExtra("maxi");
        mobile=getIntent().getStringExtra("mobile2");

        t1.setText(a);
        t2.setText(b);
        e1.setText(c);


        db.execSQL("CREATE TABLE IF NOT EXISTS tourism1(mobile NUMBER,places VARCHAR,noofpassengers NUMBER,cost NUMBER);");


        total=Integer.parseInt(t2.getText().toString())/Integer.parseInt(e1.getText().toString());

        builder = new AlertDialog.Builder(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString()!=c){
                    Toast.makeText(getApplicationContext(),"you have to pay extra charges\t"+total+"\tper person",Toast.LENGTH_SHORT).show();
                    builder.setMessage("Do you want to pay the charges for the passengers mentioned?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(getApplicationContext(),"Booking confirmed",
                                            Toast.LENGTH_SHORT).show();
                                    db.execSQL("INSERT INTO tourism1 VALUES('" +mobile + "','" + t1.getText() + "','" + e1.getText() + "','" + t2.getText() + "');");

                                    Cursor c = db.rawQuery("SELECT * FROM tourism1", null);
                                    if (c.getCount() == 0) {
                                        showMessage("Error", "No records found");
                                        return;
                                    }
                                    StringBuffer buffer = new StringBuffer();
                                    while (c.moveToNext()) {
                                        buffer.append("mobileno: " + c.getString(0) + "\n");
                                        buffer.append("source and dest: " + c.getString(1) + "\n");
                                        buffer.append("noofpassengers: " + c.getString(2) + "\n");
                                        buffer.append("totalcost: " + c.getString(3) + "\n\n");
                                    }
                                    showMessage("Recent Bookings", buffer.toString());

                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Action for 'NO' Button
                                    dialog.cancel();
                                    Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Passengers Confirmation");
                    alert.show();
                }
                total1=Integer.parseInt(e1.getText().toString()) * total;
                t2.setText(""+total1);

            }
        });

    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
