package com.example.farrago;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class EditperiodActivity extends AppCompatActivity {

    TextView textView;
    ImageButton imageButton;
    EditText editText;
    Button save;
    EditText editText2;

    //int date = getIntent().getIntExtra("Current date", 0);
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editperiod);


        textView = findViewById(R.id.date_chosen);
        imageButton = findViewById(R.id.button_dtp);
        editText = findViewById(R.id.period);
        editText2 = findViewById(R.id.next_date);
        save = findViewById(R.id.save_deets);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override

                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(year);
                        builder.append(monthOfYear);
                        builder.append(dayOfMonth);

                        textView.setText(builder);
                    }
                };

            }

        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String due = editText.getText().toString();
                String next = editText2.getText().toString();
                //String present = textView.getText().toString();
                //Intent intent = getIntent();
                Intent intent = new Intent();
                //Intent intent = new Intent(v.getContext(), Period_tracker_activity.class);
                intent.putExtra("Duration", Integer.valueOf(due));
                intent.putExtra("Next date", Integer.valueOf(next));
                //intent.putExtra("Present date", date);
                setResult(RESULT_OK, intent);
                finish();
                //startActivity(intent);
            }
        });



    }
}