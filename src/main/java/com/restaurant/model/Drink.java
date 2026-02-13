package main.java.com.restaurant.model;
import com.restaurant.model.MenuItem;
public class Drink extends MenuItem {
    private boolean isAlcoholic;
    public Drink(Long id, String name, double price, boolean isAlcoholic) {
        super(id, name, price);
        this.isAlcoholic = isAlcoholic;
    }
    public boolean isAlcoholic() { return isAlcoholic; }
}