package com.restaurant.patterns;

import com.restaurant.model.MenuItem;
import com.restaurant.model.Dish;

public class MenuFactory {
    public static MenuItem createItem(String type, Long id, String name, double price, String extra) {
        if ("DISH".equalsIgnoreCase(type)) {
            return new Dish(id, name, price, extra);
        }
        throw new IllegalArgumentException("Unknown item type");
    }
}