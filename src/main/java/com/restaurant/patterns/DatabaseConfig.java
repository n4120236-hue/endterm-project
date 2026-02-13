package com.restaurant.patterns;

public class DatabaseConfig {
    private static DatabaseConfig instance;
    private String dbUrl = "jdbc:postgresql://localhost:5432/restaurant";

    private DatabaseConfig() {}

    public static synchronized DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    public String getDbUrl() { return dbUrl; }
}