package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.layout.simple_dropdown_item_1line;
import static android.widget.Toast.LENGTH_SHORT;


public class SecondFragment extends Fragment {
EditText t9,t11,t12;
View view​;
RadioButton r1,r2;

    SQLiteDatabase db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view​ =inflater.inflate(R.layout.fragment_second ,container,false);
        t9= view​.findViewById(R.id.editText9);
        t11=view​.findViewById(R.id.editText11);
        t12=view​.findViewById(R.id.editText12);
        r1=view​.findViewById(R.id.radioButton);
        r2=view​.findViewById(R.id.radioButton2);
       db = getContext().openOrCreateDatabase("Payeasy", Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS paying(cardnum NUMBER,expdate DATE,cvv NUMBER);");
        db.execSQL("INSERT INTO paying VALUES('" + t9.getText() + "','" +t11.getText()+ "','" + t12.getText() + "');");


        return inflater.inflate(R.layout.fragment_second, container, false);
    }

}
