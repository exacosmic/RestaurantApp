package com.restaurant.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.restaurant.app.R;
import com.restaurant.app.models.FeedbackItem;

import java.util.List;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackAdapter.ViewHolder> {
    private final List<FeedbackItem> items;

    public FeedbackAdapter(List<FeedbackItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feedback, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FeedbackItem f = items.get(position);
        holder.rating.setRating(f.getRating());
        holder.comment.setText(f.getComment().isEmpty() ? "(No comment)" : f.getComment());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        RatingBar rating;
        TextView comment;

        ViewHolder(View itemView) {
            super(itemView);
            rating = itemView.findViewById(R.id.item_rating);
            comment = itemView.findViewById(R.id.item_comment);
        }
    }
}
