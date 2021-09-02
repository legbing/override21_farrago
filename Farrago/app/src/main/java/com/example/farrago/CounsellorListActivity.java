package com.example.farrago;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class CounsellorListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CounsellorAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public String[] dataset = {"Dr. Anitha", "Dr. Sneha Kamath", "Dr. ABC", "Dr. XYZ"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counsellor_list);

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new CounsellorAdapter(dataset);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}