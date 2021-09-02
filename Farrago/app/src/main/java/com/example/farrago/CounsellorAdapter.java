package com.example.farrago;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CounsellorAdapter extends RecyclerView.Adapter<CounsellorAdapter.CounsellorViewHolder> {

    private String[] localDataSet;


    public static class CounsellorViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout containerView;
        public TextView textView;

        public CounsellorViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            containerView = view.findViewById(R.id.pokedex_row);
            textView = view.findViewById(R.id.pokedex_row_text_view);
        }

    }


    public CounsellorAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CounsellorViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.counsellor_row, viewGroup, false);

        return new CounsellorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CounsellorViewHolder holder, int position) {
        holder.textView.setText(localDataSet[position]);
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}