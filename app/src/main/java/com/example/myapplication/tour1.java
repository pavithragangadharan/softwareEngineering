package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class tour1 extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] content;
    private final String[] content1;
    private final String[] content2;


    public tour1(Activity context, String[] content, String[] content1, String[]content2) {
        super(context, R.layout.tour_view, content);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.content = content;
        this.content1=content1;
        this.content2=content2;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.tour_view, null, true);

        TextView place=rowView.findViewById(R.id.textView49);
        TextView price = (TextView) rowView.findViewById(R.id.textView50);
        TextView max = rowView.findViewById(R.id.textView51);

        place.setText(content[position]);
        price.setText(content1[position]);
        max .setText(content2[position]);
        return rowView;

    };
}