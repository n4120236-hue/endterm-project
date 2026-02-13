package com.restaurant.repository;

import com.restaurant.model.MenuItem;
import com.restaurant.patterns.MenuFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuRepository {

    private final JdbcTemplate jdbcTemplate;


    public MenuRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<MenuItem> findAll() {
        String sql = "SELECT * FROM menu_items";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                MenuFactory.createItem(
                        rs.getString("type"),
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("extra_info")
                )
        );
    }

    public void save(String type, String name, double price, String extra) {
        String sql = "INSERT INTO menu_items (type, name, price, extra_info) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, type.toUpperCase(), name, price, extra);
    }
}