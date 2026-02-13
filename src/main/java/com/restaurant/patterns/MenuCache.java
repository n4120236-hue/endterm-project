package com.restaurant.patterns;

import com.restaurant.model.MenuItem;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MenuCache {
    private static MenuCache instance;
    private final Map<String, List<MenuItem>> cache = new ConcurrentHashMap<>();

    private MenuCache() {}

    public static synchronized MenuCache getInstance() {
        if (instance == null) {
            instance = new MenuCache();
        }
        return instance;
    }

    public List<MenuItem> get(String key) {
        return cache.get(key);
    }

    public void put(String key, List<MenuItem> items) {
        cache.put(key, items);
    }

    public void clear(String key) {
        cache.remove(key);
    }
}