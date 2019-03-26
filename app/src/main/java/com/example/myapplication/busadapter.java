package com.example.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class busadapter extends ArrayAdapter<String> {
    Activity context;
    String[] fill1,fill2,fill3,fill4,fill5;

    public busadapter( Activity context,String[] fill1,String[] fill2,String[] fill3,String[] fill4,String[] fill5) {
        super(context,0,fill1);
        // Toast.makeText(getContext(),fill1[0].toString(),Toast.LENGTH_LONG).show();
        this.context = context;
        this.fill1 = fill1;
        this.fill2 = fill2;
        this.fill3 = fill3;
        this.fill4 = fill4;
        this.fill5 = fill5;

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Toast.makeText(getContext(), fill1[0],Toast.LENGTH_LONG).show();
        LayoutInflater inflater=context.getLayoutInflater();

        View view=inflater.inflate(R.layout.booking_bus,parent,false);
        TextView tv1=view.findViewById(R.id.tv1);
        TextView tv2=view.findViewById(R.id.tv2);
        TextView tv3=view.findViewById(R.id.tv3);
        TextView tv4=view.findViewById(R.id.tv4);
        TextView tv5=view.findViewById(R.id.tv5);
        Button pay=view.findViewById(R.id.pay);
        //Toast.makeText(getContext(), fill1[0],Toast.LENGTH_LONG).show();

        tv1.setText(fill1[position]);
        tv2.setText("Dept "+fill2[position]);
        tv3.setText("Rs "+fill3[position]);
        tv4.setText("Seats left "+fill4[position]);
        tv5.setText("Arr "+fill5[position]);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog=new AlertDialog.Builder(getContext()).setTitle("PAYMENT").setMessage("Do you want to proceed?")
                        .setPositiveButton("Pay confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(),"All Aboard",Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getContext(),"Cancelled reservation",Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                alertDialog.show();
            }
        });
        return view;
    }
}
