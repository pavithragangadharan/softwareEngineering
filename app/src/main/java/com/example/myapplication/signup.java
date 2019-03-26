package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity {
Button b;
EditText e1, e2,e3,e4,e5;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        db = openOrCreateDatabase("Payeasy", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS signup(name VARCHAR,email VARCHAR,mobile NUMBER,password VARCHAR);");
        b=findViewById(R.id.button);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText4);
        e3=findViewById(R.id.editText5);
        e4=findViewById(R.id.editText6);
        e5=findViewById(R.id.editText7);

        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                String x =e4.getText().toString().trim();
                String y =e5.getText().toString().trim();
                if (e1.getText().toString().trim().length() == 0 || e2.getText().toString().trim().length() == 0 ||
                        e3.getText().toString().trim().length() == 0||  e4.getText().toString().trim().length() == 0||  e5.getText().toString().trim().length() == 0) {
                    showMessage("Error", "Please enter all values");
                    return;
                }
                else if (!x.equals(y)){
                    showMessage("Error", "Check the password");
                }
                else {

                    db.execSQL("INSERT INTO signup VALUES('" + e1.getText() + "','" + e2.getText() + "','" + e3.getText() + "','" + e4.getText() + "');");
                    showMessage("Success", "Record added");
                    clearText();
                    Intent i = new Intent(signup.this, login.class);
                    startActivity(i);
                    finishAffinity();
                }
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
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
    }
}
