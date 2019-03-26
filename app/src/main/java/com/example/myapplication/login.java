package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
TextView t,t1;
Button b1;
EditText edit1,edit2;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = openOrCreateDatabase("Payeasy", Context.MODE_PRIVATE, null);

        t = findViewById(R.id.textView10);
        b1 = findViewById(R.id.button2);
        edit1 = findViewById(R.id.editText2);
        edit2 = findViewById(R.id.editText3);


        t.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, signup.class);
                startActivity(i);
                finishAffinity();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                String a = edit1.getText().toString().trim();
                String b = edit2.getText().toString().trim();

                Cursor c = db.rawQuery("SELECT * FROM signup", null);

                while (c.moveToNext()) {
                    String c1 = c.getString(2);
                    String c2 = c.getString(3);

                    if (c1.equals(a)) {
                        if (c2.equals(b)) {
                            Toast.makeText(login.this,
                                    "You are succesfully logged in.",
                                    Toast.LENGTH_LONG).show();
                            Intent i = new Intent(login.this, Mainpage.class);
                            i.putExtra("mobile1",a);
                            startActivity(i);
                            finishAffinity();
                        }
                        else {
                            Toast.makeText(login.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                        }


                    }



                }




            }
        });
    }
}