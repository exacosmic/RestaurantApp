package com.restaurant.app;

import com.restaurant.app.models.Address;
import com.restaurant.app.models.FeedbackItem;
import com.restaurant.app.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory store for addresses and feedback (demo only).
 */
public class DataStore {
    private static DataStore instance;
    private final List<Address> addresses = new ArrayList<>();
    private final List<FeedbackItem> feedbackList = new ArrayList<>();
    private Address selectedAddress;

    public static synchronized DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    public List<Address> getAddresses() {
        return new ArrayList<>(addresses);
    }

    public void addAddress(Address a) {
        addresses.add(a);
    }

    public Address getSelectedAddress() {
        return selectedAddress;
    }

    public void setSelectedAddress(Address a) {
        selectedAddress = a;
    }

    public List<FeedbackItem> getFeedbackList() {
        return new ArrayList<>(feedbackList);
    }

    public void addFeedback(FeedbackItem f) {
        feedbackList.add(0, f);
    }

    public static List<MenuItem> getDefaultMenu() {
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem(1, "Margherita Pizza", 12.99, R.drawable.ic_food_pizza));
        menu.add(new MenuItem(2, "Pepperoni Pizza", 14.99, R.drawable.ic_food_pizza));
        menu.add(new MenuItem(3, "Caesar Salad", 8.99, R.drawable.ic_food_salad));
        menu.add(new MenuItem(4, "Burger & Fries", 11.99, R.drawable.ic_food_burger));
        menu.add(new MenuItem(5, "Pasta Carbonara", 13.99, R.drawable.ic_food_pasta));
        menu.add(new MenuItem(6, "Grilled Chicken", 15.99, R.drawable.ic_food_chicken));
        menu.add(new MenuItem(7, "Fish & Chips", 14.99, R.drawable.ic_food_fish));
        menu.add(new MenuItem(8, "Ice Cream", 4.99, R.drawable.ic_food_dessert));
        menu.add(new MenuItem(9, "Soft Drink", 2.99, R.drawable.ic_food_drink));
        menu.add(new MenuItem(10, "Coffee", 3.49, R.drawable.ic_food_coffee));
        return menu;
    }
}
