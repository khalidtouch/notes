package com.example.notes;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    private LinkedList<Word> mWords;
    private LayoutInflater mInflater;

    public WordAdapter(Context context, LinkedList<Word> words){
        mInflater = LayoutInflater.from(context);
        this.mWords = words;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_layout, parent, false);
        return new WordViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        Word currentWord = mWords.get(position);
        holder.itemTextView.setText(currentWord.getText());
    }

    public void setNote(LinkedList<Word> notes){
        mWords = notes;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mWords != null){
            return mWords.size();
        }
       return 0;
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView itemTextView;
        private WordAdapter mWordAdapter;

        public WordViewHolder(@NonNull View itemView, WordAdapter adapter) {
            super(itemView);
            this.mWordAdapter = adapter;
            itemTextView = itemView.findViewById(R.id.item_text_view);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            // make adjustment when clicked
            Word clickedWord = mWords.get(mPosition);

        }
    }
}
