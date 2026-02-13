package com.restaurant.model;

public class Dish extends MenuItem {
    private String category;
    public Dish(Long id, String name, double price, String category) {
        super(id, name, price);
        this.category = category;
    }
    public String getCategory() { return category; }
}