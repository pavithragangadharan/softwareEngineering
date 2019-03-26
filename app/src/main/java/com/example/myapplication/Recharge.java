package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Recharge extends AppCompatActivity implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener{
TextView txt,txt1;
    Button b;
    EditText t1,t2;
    Spinner s1,s2;
    ListView list;
    SQLiteDatabase db;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        db = openOrCreateDatabase("Payeasy", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS recharge(mobile NUMBER,service VARCHAR,type VARCHAR,plan1 VARCHAR);");

        b=findViewById(R.id.button3);
        t1=findViewById(R.id.editText8);
        t2=findViewById(R.id.editText10);


        String type[]={"prepaid","postpaid"};
        s1=findViewById(R.id.spinner);
         ArrayAdapter<String> adap1= new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,type);
        s1.setAdapter(adap1);
        s1.setOnItemSelectedListener(this);


        String services[]={"BSNL","AIRTEL","JIO"};;
        s2=(Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adap2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,services);
        s2.setAdapter(adap2);
        s2.setOnItemSelectedListener(this);


        final String mobile []= {"199/28days-Unlimited talktime","248/64days-Unlimited talktime","365/98days-Unlimited talktime","478/120days-Unlimited talktime","528/5months-Unlimited talktime","640/6months-Unlimited talktime"};
        list=findViewById(R.id.listview);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, mobile);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
               Toast.makeText(getApplicationContext(),mobile[position],Toast.LENGTH_SHORT).show();

               t2.setText(""+mobile[position]);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                if(t1.getText().length()==10) {
                    db.execSQL("INSERT INTO recharge VALUES('" + t1.getText() + "','" + txt1.getText() + "','" + txt.getText() + "','" + t2.getText() + "');");
                    Toast.makeText(getApplicationContext(), "Recharge is sucessfully done ", LENGTH_SHORT).show();
                    Cursor c = db.rawQuery("SELECT * FROM recharge", null);
                    if (c.getCount() == 0) {
                        showMessage("Error", "No records found");
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (c.moveToNext()) {
                        buffer.append("Mobile no: " + c.getString(0) + "\n");
                        buffer.append("Service name: " + c.getString(1) + "\n");
                        buffer.append("Type: " + c.getString(2) + "\n\n");
                        buffer.append("Plan: " + c.getString(3) + "\n\n");
                    }
                    showMessage("Recent Recharges", buffer.toString());
                }
                else{
                    Toast.makeText(getApplicationContext(),"check your phone number",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==R.id.spinner) {
            Log.d("MainActivity", "item selected");
             txt = (TextView) view;

            //Checked Text view
            Log.d("spinner1",txt.getText().toString());
            Toast.makeText(getApplicationContext(), "You have selected " + txt.getText(), LENGTH_SHORT).show();
        }
        else if(parent.getId()==R.id.spinner2)
        {
             txt1 = (TextView) view;
            Toast.makeText(getApplicationContext(), "You have selected " + txt1.getText(), LENGTH_SHORT).show();
            Log.d("spinner2",txt1.getText().toString());
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(getApplicationContext(), "No selection yet", LENGTH_SHORT).show();

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        Toast.makeText(getApplicationContext(), "No selection ", LENGTH_SHORT).show();
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}


