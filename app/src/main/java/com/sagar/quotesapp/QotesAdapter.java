package com.sagar.quotesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class QotesAdapter extends RecyclerView.Adapter<QotesAdapter.ViewHolder>  {

    Context mcontext;
    List<QuotesModel> mData;

    public QotesAdapter(Context mcontext, List<QuotesModel> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
             holder.Quote.setText(mData.get(position).getQuote());
             holder.Author.setText(mData.get(position).getAuthor());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Quote,Author;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Quote = itemView.findViewById(R.id.TV_quotes);
            Author = itemView.findViewById(R.id.TV_author);

        }
    }
}
