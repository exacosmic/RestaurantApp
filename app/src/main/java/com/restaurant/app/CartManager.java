package com.restaurant.app;

import com.restaurant.app.models.CartItem;
import com.restaurant.app.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton cart: add/remove items, total.
 */
public class CartManager {
    private static CartManager instance;
    private final List<CartItem> items = new ArrayList<>();

    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public void addItem(MenuItem menuItem, int quantity) {
        for (CartItem ci : items) {
            if (ci.getMenuItem().getId() == menuItem.getId()) {
                ci.setQuantity(ci.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(menuItem, quantity));
    }

    public void removeItem(CartItem item) {
        items.remove(item);
    }

    public void clear() {
        items.clear();
    }

    public double getTotal() {
        double total = 0;
        for (CartItem ci : items) {
            total += ci.getSubtotal();
        }
        return total;
    }

    public int getItemCount() {
        int count = 0;
        for (CartItem ci : items) {
            count += ci.getQuantity();
        }
        return count;
    }
}
