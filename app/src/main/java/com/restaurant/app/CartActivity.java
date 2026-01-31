package com.restaurant.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.restaurant.app.adapters.CartAdapter;
import com.restaurant.app.models.CartItem;

import java.util.List;
import java.util.Locale;

public class CartActivity extends AppCompatActivity implements CartAdapter.OnCartChangeListener {

    private RecyclerView recycler;
    private TextView totalPrice;
    private MaterialButton btnCheckout;
    private CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        recycler = findViewById(R.id.recycler_cart);
        totalPrice = findViewById(R.id.total_price);
        btnCheckout = findViewById(R.id.btn_checkout);

        recycler.setLayoutManager(new LinearLayoutManager(this));
        List<CartItem> items = CartManager.getInstance().getItems();
        adapter = new CartAdapter(items, this);
        recycler.setAdapter(adapter);

        btnCheckout.setOnClickListener(v -> {
            if (CartManager.getInstance().getItemCount() == 0) {
                Toast.makeText(this, "Cart is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(new Intent(this, CheckoutActivity.class));
        });

        refreshCart();
    }

    @Override
    public void onCartChanged() {
        refreshCart();
    }

    private void refreshCart() {
        List<CartItem> items = CartManager.getInstance().getItems();
        adapter.setItems(items);
        double total = CartManager.getInstance().getTotal();
        totalPrice.setText(String.format(Locale.US, "$%.2f", total));
        btnCheckout.setEnabled(items.size() > 0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshCart();
    }
}
