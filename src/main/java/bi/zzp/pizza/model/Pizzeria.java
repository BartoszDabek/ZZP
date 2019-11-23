package bi.zzp.pizza.model;

import bi.zzp.pizza.calculation.PriceCalculator;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
public class Pizzeria implements Observable {

    private List<Observer> observers = new ArrayList<>();

    public Pizza createNewPizza() {
        Scanner in = new Scanner(System.in);
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        System.out.println("What type of dough do you want? (ITALIAN, POLISH, AMERICAN, CEREAL)");
        String dough = in.nextLine();

        System.out.println("What type of sauce? (GARLIC, BBQ, CHILI)");
        String sauce = in.nextLine();

        System.out.println("What pizza do you want? (Firm, Margherita, Chicken, etc..)");
        String name = in.nextLine();

        System.out.println("What size of pizza? (SMALL, MEDIUM, LARGE, EXTRA)");
        String size = in.nextLine();

        while (true) {
            System.out.println("What topping do you want?");
            pizzaBuilder.addTopping(in.nextLine());

            System.out.println("Next topping? (YES/NO)");
            String nextTopping = in.nextLine();
            if ("NO".equalsIgnoreCase(nextTopping)) {
                break;
            }
        }

        return pizzaBuilder
                .withDough(dough)
                .withSauce(sauce)
                .withName(name)
                .withSize(size)
                .build();
    }

    public int calculatePriceFor(Pizza pizza) {
        PriceCalculator priceCalculator = new PriceCalculator();
        return priceCalculator.calculatePrice(pizza);
    }

    @Override
    public void add(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notify(Pizza pizza, String clientAddress, int price) {
        this.observers.forEach(o -> o.update(pizza, clientAddress, price));
    }

    public void createPizzaForSupplierDelivery(String clientAddress) {
        Pizza pizza = createNewPizza();
        int price = calculatePriceFor(pizza);
        notify(pizza, clientAddress, price);
    }
}
