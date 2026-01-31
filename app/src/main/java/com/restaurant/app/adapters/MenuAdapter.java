package com.restaurant.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.restaurant.app.R;
import com.restaurant.app.models.MenuItem;

import java.util.List;
import java.util.Locale;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private final List<MenuItem> items;
    private final OnAddClickListener listener;

    public interface OnAddClickListener {
        void onAddClick(MenuItem item);
    }

    public MenuAdapter(List<MenuItem> items, OnAddClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuItem item = items.get(position);
        holder.name.setText(item.getName());
        holder.price.setText(String.format(Locale.US, "$%.2f", item.getPrice()));
        holder.btnAdd.setOnClickListener(v -> {
            if (listener != null) listener.onAddClick(item);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        MaterialButton btnAdd;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
            btnAdd = itemView.findViewById(R.id.btn_add);
        }
    }
}
