package com.restaurant.app;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.restaurant.app.adapters.MenuAdapter;
import com.restaurant.app.models.MenuItem;

import java.util.List;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recycler = findViewById(R.id.recycler_menu);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        List<MenuItem> menu = DataStore.getDefaultMenu();
        MenuAdapter adapter = new MenuAdapter(menu, item -> {
            CartManager.getInstance().addItem(item, 1);
            Toast.makeText(this, item.getName() + " added to cart", Toast.LENGTH_SHORT).show();
        });
        recycler.setAdapter(adapter);
    }
}
