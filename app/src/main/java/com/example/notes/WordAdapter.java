package com.example.notes;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {


    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder{
        private TextView itemTextView;
        private WordAdapter mWordAdapter;

        public WordViewHolder(@NonNull View itemView, WordAdapter adapter) {
            super(itemView);
            this.mWordAdapter = adapter;
            itemTextView = itemView.findViewById(R.id.item_text_view);
        }
    }
}
