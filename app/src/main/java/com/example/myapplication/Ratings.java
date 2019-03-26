package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class Ratings extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    int numberOfStars;
    RatingBar simpleRatingBar;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        db = openOrCreateDatabase("Payeasy", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS ratings(mobileno NUMBER,feedback VARCHAR,ratings NUMBER);");

        simpleRatingBar = (RatingBar) findViewById(R.id.simpleRatingBar); // initiate a rating bar
         numberOfStars = simpleRatingBar.getNumStars();
        simpleRatingBar.setBackgroundColor(Color.YELLOW);
        simpleRatingBar.setNumStars(5);
        e1=findViewById(R.id.editText17);
        e2=findViewById(R.id.editText15);
        b1=findViewById(R.id.button7);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String totalStars = "Total Stars:: " + numberOfStars;
                String rating = "Rating :: " + simpleRatingBar.getRating();

                if (e2.getText().toString().length() >30 ) {
                    e1.setTextColor(Color.BLACK);
                    Toast.makeText(getApplicationContext(),"Give the feedeback in very short form ",Toast.LENGTH_SHORT).show();
                    e2.setTextColor(Color.RED);

                }
                else if(e1.getText().toString().length() != 10){
                    e2.setTextColor(Color.BLACK);
                    Toast.makeText(getApplicationContext()," check the mobile no",Toast.LENGTH_SHORT).show();
                    e1.setTextColor(Color.RED);

                }
                else if(e1.getText().toString().length() != 10 && e2.getText().toString().length() >30){

                    Toast.makeText(getApplicationContext(),"Give the feedeback in very short form and check the mobile no",Toast.LENGTH_SHORT).show();
                    e1.setTextColor(Color.RED);
                    e2.setTextColor(Color.RED);
                }
                else{
                    e2.setTextColor(Color.BLACK);
                    e1.setTextColor(Color.BLACK);

                    db.execSQL("INSERT INTO ratings VALUES('" + e1.getText() + "','" + e2.getText() + "','" + rating + "');");

                    Cursor c = db.rawQuery("SELECT * FROM ratings", null);
                    if (c.getCount() == 0) {
                        showMessage("Error", "No records found");
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (c.moveToNext()) {
                        buffer.append("mobileno: " + c.getString(0) + "\n");
                        buffer.append("feedback: " + c.getString(1) + "\n");
                        buffer.append("ratings: " + c.getString(2) + "\n\n");

                    }
                    Toast.makeText(getApplicationContext(), rating + "/" + totalStars, Toast.LENGTH_SHORT).show();
                    showMessage("Recent Feedbacks", buffer.toString());
                    clearText();
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
        simpleRatingBar.setRating(0);

    }
}
