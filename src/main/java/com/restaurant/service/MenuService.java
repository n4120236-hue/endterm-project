package com.restaurant.service;

import com.restaurant.model.MenuItem;
import com.restaurant.repository.MenuRepository;
import com.restaurant.patterns.MenuCache;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {
    private final MenuRepository repository;
    private final MenuCache cache = MenuCache.getInstance();
    private final String CACHE_KEY = "all_menu_items";

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public List<MenuItem> getAllItems() {
        List<MenuItem> cachedData = cache.get(CACHE_KEY);

        if (cachedData != null) {
            System.out.println("[CACHE] Returning cached data...");
            return cachedData;
        }

        System.out.println("[DATABASE] Fetching from database...");
        List<MenuItem> items = repository.findAll();
        cache.put(CACHE_KEY, items);
        return items;
    }

    public void addItem(String type, String name, double price, String extra) {
        repository.save(type, name, price, extra);
        System.out.println("[CACHE] Invaliding cache after update...");
        cache.clear(CACHE_KEY);
    }
}