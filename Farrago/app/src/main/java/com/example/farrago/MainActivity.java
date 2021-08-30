package com.example.farrago;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView image1;
    ImageView image2;
    ImageView image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.card1);
        image2 = findViewById(R.id.card2);
    }

    public void onClickCard(View view)
    {
        if(image1.callOnClick())
            startActivity(new Intent(this, Period_tracker_activity.class));
        else if(image2.callOnClick())
            startActivity(new Intent(this, Period_tracker_activity.class));
    }

}