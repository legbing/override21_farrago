package com.example.farrago;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Period_tracker_activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    //private CalendarAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Button editButton;
    TextView dayNo;
    TextView update;

    HashMap<Integer, Integer> map = new HashMap<>();


    public int current_date;
    int no_of_days;
    int next_date;
    public int selected_date;
    CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period_tracker_activity);


        //recyclerView = findViewById(R.id.recycler_view);
        editButton = findViewById(R.id.edit_period);
        dayNo = findViewById(R.id.day_1);
        update = findViewById(R.id.update);
        calendar = findViewById(R.id.calendar);
        //adapter = new CalendarAdapter(getApplicationContext(), dayNo);
        //layoutManager = new LinearLayoutManager(this);

        //recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(layoutManager);


        CalendarView view = new CalendarView(this);
        //setContentView(view);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView arg0, int year, int month,
                                            int date) {
                selected_date = next_date;
                current_date = date;
                Log.d("Date changes", String.valueOf(current_date));
                map.put(current_date, no_of_days);
                if(current_date < selected_date)
                {
                    dayNo.setText((selected_date - current_date) + "more days for your period!!");
                    update.setText("");
                }
                else if(current_date >= selected_date) {
                    Log.d("Date stored2", String.valueOf(current_date));
                    dayNo.setText("Day " + (current_date - selected_date+1));
                    update.setText((no_of_days - (current_date - selected_date+1)) + "more days to go!!");
                }
            }
        });



        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditperiodActivity.class);
                selected_date = current_date;
                Log.d("Date stored", String.valueOf(current_date));
                startActivityForResult(intent, 1);

            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data != null)
        {
            no_of_days = data.getIntExtra("Duration", 0);
            Log.d("duration: ", String.valueOf(no_of_days));
            next_date = data.getIntExtra("Next date", 0);
            Log.d("duration: ", String.valueOf(no_of_days));
            //selected_date = data.getIntExtra("Present date", 0);
            //Log.d("duration: ", String.valueOf(no_of_days));
        }
    }
}