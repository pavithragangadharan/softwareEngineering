package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class movies1 extends AppCompatActivity {

    private ListView lv;

    private ArrayAdapter<String> adapter;

    int icons[]={R.drawable.captain,R.drawable.wonder,R.drawable.gullyboy,R.drawable.badla,R.drawable.ntr,R.drawable.vvr,R.drawable.thadam,R.drawable.lkg};
    String names[]={"Captain Marvel","Wonder Park","Gully Boy","Badla","NTR Mahanayakudu","Vinaya Vidheya Rama","Thadam","LKG"};
    String likes[]={"89%","75%","85%","92%","72%","56%","82%","69%"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies1);

        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<8;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("icons", Integer.toString(icons[i]) );
            hm.put("na"," " + names[i]);
            hm.put("like","Likes : " + likes[i]);
            aList.add(hm);
        }
        String[] from = { "icons","na","like" };

        // Ids of views in listview_layout
        int[] to = { R.id.imageView15,R.id.textView37,R.id.textView39};

        lv = (ListView) findViewById(R.id.listview3);
       SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.movie_list,from,to);
        ListView androidListView = (ListView) findViewById(R.id.listview3);
        lv.setAdapter(simpleAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

                // Getting listview click value into String variable.
                String TempListViewClickedValue = names[position].toString();

                Intent intent = new Intent(movies1.this, Movies.class);

                // Sending value to another activity using intent.
                intent.putExtra("ListViewClickedValue", TempListViewClickedValue);

                startActivity(intent);
                finishAffinity();

            }
        });
    }
}
