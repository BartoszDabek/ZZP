package bi.zzp.builder.model;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    private List<Topping> toppings = new ArrayList<>();
    private Size size;
    private String name;
    private Sauce sauce;
    private Dough dough;

    public PizzaBuilder addTopping(String topping) {
        this.toppings.add(Topping.valueOf(topping));
        return this;
    }

    public PizzaBuilder withSize(String size) {
        if (size.isBlank()) {
            size = "medium";
        }
        this.size = Size.valueOf(size);
        return this;
    }

    public PizzaBuilder withName(String name) {
        if (name.isBlank()) {
            name = "margherita";
        }
        this.name = name;
        return this;
    }

    public PizzaBuilder withSauce(String sauceValue) {
        if (sauceValue.isBlank()) {
            sauceValue = "bbq";
        }
        this.sauce = Sauce.valueOf(sauceValue);
        return this;
    }

    public PizzaBuilder withDough(String doughValue) {
        if (doughValue.isBlank()) {
            doughValue = "italian";
        }
        this.dough = Dough.valueOf(doughValue);
        return this;
    }

    public Pizza build() {
        return new Pizza(dough, sauce, toppings, name, size);
    }
}
