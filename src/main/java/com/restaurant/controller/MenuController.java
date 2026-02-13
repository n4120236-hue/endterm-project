package com.restaurant.controller;

import com.restaurant.model.MenuItem;
import com.restaurant.service.MenuService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    private final MenuService service;
    public MenuController(MenuService service) { this.service = service; }
    @GetMapping
    public List<MenuItem> getMenu() { return service.getAllItems(); }
    @PostMapping
    public void create(@RequestParam String type, @RequestParam String name,
                       @RequestParam double price, @RequestParam String extra) {
        service.addItem(type, name, price, extra);
    }
}