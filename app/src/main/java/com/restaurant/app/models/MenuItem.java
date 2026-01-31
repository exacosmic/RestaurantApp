package com.restaurant.app.models;

/**
 * Represents a menu item (dish) in the restaurant.
 */
public class MenuItem {
    private final int id;
    private final String name;
    private final double price;
    private final int imageResId;

    public MenuItem(int id, String name, double price, int imageResId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageResId = imageResId;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getImageResId() { return imageResId; }
}
