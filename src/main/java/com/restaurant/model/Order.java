package main.java.com.restaurant.model;
import com.restaurant.model.MenuItem;
import java.util.List;

public class Order {
    private Long id;
    private String tableNumber;
    private List<MenuItem> items;
    private String notes;

    private Order(Builder builder) {
        this.id = builder.id;
        this.tableNumber = builder.tableNumber;
        this.items = builder.items;
        this.notes = builder.notes;
    }

    public static class Builder {
        private Long id;
        private String tableNumber;
        private List<MenuItem> items;
        private String notes;

        public Builder setId(Long id) { this.id = id; return this; }
        public Builder setTable(String table) { this.tableNumber = table; return this; }
        public Builder setItems(List<MenuItem> items) { this.items = items; return this; }
        public Builder setNotes(String notes) { this.notes = notes; return this; }
        public Order build() { return new Order(this); }
    }
}