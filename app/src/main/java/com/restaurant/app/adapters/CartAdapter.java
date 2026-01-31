package com.restaurant.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.restaurant.app.R;
import com.restaurant.app.models.CartItem;

import java.util.List;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<CartItem> items;
    private final OnCartChangeListener listener;

    public interface OnCartChangeListener {
        void onCartChanged();
    }

    public CartAdapter(List<CartItem> items, OnCartChangeListener listener) {
        this.items = items;
        this.listener = listener;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem ci = items.get(position);
        holder.name.setText(ci.getMenuItem().getName());
        holder.qty.setText("x" + ci.getQuantity());
        holder.price.setText(String.format(Locale.US, "$%.2f", ci.getSubtotal()));
        holder.btnRemove.setOnClickListener(v -> {
            com.restaurant.app.CartManager.getInstance().removeItem(ci);
            if (listener != null) listener.onCartChanged();
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, qty, price;
        ImageButton btnRemove;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.cart_item_name);
            qty = itemView.findViewById(R.id.cart_item_qty);
            price = itemView.findViewById(R.id.cart_item_price);
            btnRemove = itemView.findViewById(R.id.btn_remove);
        }
    }
}
