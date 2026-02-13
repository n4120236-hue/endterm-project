package com.restaurant;

import com.restaurant.service.MenuService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner testCache(MenuService menuService) {
        return args -> {

            System.out.println("\n--- ТЕСТ: ПЕРВЫЙ ЗАПРОС ---");
            menuService.getAllItems();

            System.out.println("\n--- ТЕСТ: ПОВТОРНЫЙ ЗАПРОС (ИЗ КЭША) ---");
            menuService.getAllItems();


            System.out.println("\n--- ТЕСТ: ДОБАВЛЕНИЕ И СБРОС КЭША ---");
            menuService.addItem("Dish", "Pasta", 15.0, "Italian");

            System.out.println("\n--- ТЕСТ: ЗАПРОС ПОСЛЕ СБРОСА ---");
            menuService.getAllItems();
        };
    }
}