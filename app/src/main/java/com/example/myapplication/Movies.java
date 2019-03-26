package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Movies extends AppCompatActivity {
    Button b2;
    TextView t1, t2, t3;
    EditText e1;
    int c2, c1;
    int a;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        db = openOrCreateDatabase("Payeasy", Context.MODE_PRIVATE, null);

        t3 = findViewById(R.id.textView27);
        t1 = findViewById(R.id.textView33);
        t2 = findViewById(R.id.textView36);
        e1 = findViewById(R.id.editText14);
        b2 = findViewById(R.id.button5);

        String TempHolder = getIntent().getStringExtra("ListViewClickedValue");
        t3.setText(TempHolder);

        db.execSQL("CREATE TABLE IF NOT EXISTS movies(name VARCHAR,noofseats NUMBER,cost NUMBER,totalcost NUMBER);");

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (t3.getText().toString().trim().equals("Captain Marvel")) {
                        c1 = 200;
                        t1.setText("Rs." + String.valueOf(c1));
                        c2 = Integer.parseInt(e1.getText().toString().trim());

                        if (c2 > 5) {
                            Toast.makeText(getApplicationContext(), "Only 4 bookings/day possible through an account", Toast.LENGTH_SHORT).show();
                        } else {
                            a = c2 * c1;
                            t2.setText("" + a);
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n" + "total cost is:" + a, Toast.LENGTH_SHORT).show();
                            db.execSQL("INSERT INTO movies VALUES('" +t3.getText() + "','" + e1.getText() + "','" + t1.getText() + "','" + t2.getText() + "');");
                          //  Intent i =new Intent(getApplicationContext(),movies1.class);
                        //    startActivity(i);

                        }
                    }
                    if (t3.getText().toString().trim().equals("Wonder Park") ){
                        int c1=100;
                        t1.setText("RS."+String.valueOf(c1));
                        int c2=Integer.parseInt(e1.getText().toString().trim());

                        if(c2>5){
                            Toast.makeText(getApplicationContext(),"Only 4 bookings/day possible through an account",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            a = c2 * c1;
                            t2.setText("" + a);
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n"+"total cost is:"+a, Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n" + "total cost is:" + a, Toast.LENGTH_SHORT).show();
                            db.execSQL("INSERT INTO movies VALUES('" +t3.getText() + "','" + e1.getText() + "','" + t1.getText() + "','" + t2.getText() + "');");
                          //  Intent i =new Intent(getApplicationContext(),movies1.class);
                         //   startActivity(i);

                        }
                    }
                    if (t3.getText().toString().trim().equals("Gully Boy")){
                        int c1=150;
                        t1.setText("RS."+String.valueOf(c1));
                        int c2=Integer.parseInt(e1.getText().toString().trim());

                        if(c2>5){
                            Toast.makeText(getApplicationContext(),"Only 4 bookings/day possible through an account",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            a = c2 * c1;
                            t2.setText("" + a);
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n"+"total cost is:"+a, Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n" + "total cost is:" + a, Toast.LENGTH_SHORT).show();
                            db.execSQL("INSERT INTO movies VALUES('" +t3.getText() + "','" + e1.getText() + "','" + t1.getText() + "','" + t2.getText() + "');");
                         //   Intent i =new Intent(getApplicationContext(),movies1.class);
                          //  startActivity(i);

                        }
                    }
                    if (t3.getText().toString().trim().equals("Badla")) {
                        int c1=125;
                        t1.setText("RS."+String.valueOf(c1));
                        int c2=Integer.parseInt(e1.getText().toString().trim());

                        if(c2>5){
                            Toast.makeText(getApplicationContext(),"Only 4 bookings/day possible through an account",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            a = c2 * c1;
                            t2.setText("" + a);
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n"+"total cost is:"+a, Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n" + "total cost is:" + a, Toast.LENGTH_SHORT).show();
                            db.execSQL("INSERT INTO movies VALUES('" +t3.getText() + "','" + e1.getText() + "','" + t1.getText() + "','" + t2.getText() + "');");
                          //  Intent i =new Intent(getApplicationContext(),movies1.class);
                           // startActivity(i);

                        }

                    }
                    if (t3.getText().toString().trim().equals("NTR Mahanayakudu")) {
                        int c1=150;
                        t1.setText("RS."+String.valueOf(c1));
                        int c2=Integer.parseInt(e1.getText().toString().trim());

                        if(c2>5){
                            Toast.makeText(getApplicationContext(),"Only 4 bookings/day possible through an account",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            a = c2 * c1;
                            t2.setText("" + a);
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n"+"total cost is:"+a, Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n" + "total cost is:" + a, Toast.LENGTH_SHORT).show();
                            db.execSQL("INSERT INTO movies VALUES('" +t3.getText() + "','" + e1.getText() + "','" + t1.getText() + "','" + t2.getText() + "');");
                           // Intent i =new Intent(getApplicationContext(),movies1.class);
                         //   startActivity(i);

                        }

                    }
                    if (t3.getText().toString().trim().equals("Vinaya Vidheya Rama")) {
                        int c1=150;
                        t1.setText("RS."+String.valueOf(c1));
                        int c2=Integer.parseInt(e1.getText().toString().trim());

                        if(c2>5){
                            Toast.makeText(getApplicationContext(),"Only 4 bookings/day possible through an account",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            a = c2 * c1;
                            t2.setText("" + a);
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n"+"total cost is:"+a, Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n" + "total cost is:" + a, Toast.LENGTH_SHORT).show();
                            db.execSQL("INSERT INTO movies VALUES('" +t3.getText() + "','" + e1.getText() + "','" + t1.getText() + "','" + t2.getText() + "');");
                          //  Intent i =new Intent(getApplicationContext(),movies1.class);
                          //  startActivity(i);

                        }

                    }
                    if (t3.getText().toString().trim().equals("Thadam")) {
                        int c1=150;
                        t1.setText("RS."+String.valueOf(c1));
                        int c2=Integer.parseInt(e1.getText().toString().trim());

                        if(c2>5){
                            Toast.makeText(getApplicationContext(),"Only 4 bookings/day possible through an account",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            a = c2 * c1;
                            t2.setText("" + a);
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n"+"total cost is:"+a, Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n" + "total cost is:" + a, Toast.LENGTH_SHORT).show();
                            db.execSQL("INSERT INTO movies VALUES('" +t3.getText() + "','" + e1.getText() + "','" + t1.getText() + "','" + t2.getText() + "');");
                         //   Intent i =new Intent(getApplicationContext(),movies1.class);
                        //    startActivity(i);

                        }

                    }
                    if (t3.getText().toString().trim().equals("LKG")) {
                        int c1=150;
                        t1.setText("RS."+String.valueOf(c1));
                        int c2=Integer.parseInt(e1.getText().toString().trim());

                        if(c2>5){
                            Toast.makeText(getApplicationContext(),"Only 4 bookings/day possible through an account",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            a = c2 * c1;
                            t2.setText("" + a);
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n"+"total cost is:"+a, Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "movie booked sucessfully\n" + "total cost is:" + a, Toast.LENGTH_SHORT).show();
                            db.execSQL("INSERT INTO movies VALUES('" +t3.getText() + "','" + e1.getText() + "','" + t1.getText() + "','" + t2.getText() + "');");
                         //   Intent i =new Intent(getApplicationContext(),movies1.class);
                         //   startActivity(i);

                        }

                    }
                    Cursor c = db.rawQuery("SELECT * FROM movies", null);
                    if (c.getCount() == 0) {
                        showMessage("Error", "No records found");
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (c.moveToNext()) {
                        buffer.append("moviename: " + c.getString(0) + "\n");
                        buffer.append("noofseats: " + c.getString(1) + "\n");
                        buffer.append("cost: " + c.getString(2) + "\n");
                        buffer.append("totalcost: " + c.getString(3) + "\n\n");
                    }
                    showMessage("Recent Bookings", buffer.toString());


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
    public void clearText(){


        e1.setText("");
        t2.setText("");

    }

    }
