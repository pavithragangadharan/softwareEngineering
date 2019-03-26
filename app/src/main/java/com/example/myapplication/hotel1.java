package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class hotel1 extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] content;
    private final String[] content1;
    private final int[] imgid;

    public hotel1(Activity context, String[] content, String[] content1, int[] imgid) {
        super(context, R.layout.hotel_list, content);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.content = content;
        this.content1=content1;
        this.imgid = imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.hotel_list, null, true);

        TextView hotels=rowView.findViewById(R.id.textView38);
        TextView price = (TextView) rowView.findViewById(R.id.textView41);
        ImageView image = (ImageView) rowView.findViewById(R.id.imageView16);

        hotels.setText(content[position]);
        price.setText(content1[position]);
        image.setImageResource(imgid[position]);
        return rowView;

    };
}
