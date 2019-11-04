package bi.zzp.builder;

import bi.zzp.builder.model.Pizza;
import bi.zzp.builder.model.PizzaBuilder;
import bi.zzp.builder.model.Size;
import bi.zzp.builder.model.Topping;

import java.util.List;
import java.util.Scanner;

import static bi.zzp.builder.model.Dough.CEREAL;
import static bi.zzp.builder.model.Topping.ANANAS;

public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        Pizza pizza = addPizza();
        int price = calculatePrice(pizza);
        System.out.println(price);
    }

    private int calculatePrice(Pizza pizza) {
        Size size = pizza.getSize();
        int price = 0;

        switch (size) {
            case SMALL:
                if (pizza.getToppings().size() <= 2) {
                    price = 18;
                } else {
                    price = 22;
                }
                break;
            case MEDIUM:
                if (pizza.getToppings().size() <= 3) {
                    if (getMeatToppingsPercentage(pizza.getToppings()) < 50) {
                        price = 25;
                    } else {
                        price = 27;
                    }
                } else {
                    if (getMeatToppingsPercentage(pizza.getToppings()) < 40) {
                        price = 27;
                    } else {
                        price = 29;
                    }
                }
                break;
            case LARGE:
                if (pizza.getToppings().size() <= 3) {
                    if (getMeatToppingsPercentage(pizza.getToppings()) < 50) {
                        price = 30;
                    } else {
                        price = 35;
                    }
                } else {
                    if (pizza.getToppings().contains(ANANAS)) {
                        price = 37;
                    }
                }
                if (pizza.getDough() == CEREAL) {
                    price += 5;
                }
                break;
            case EXTRA:
                if (pizza.getToppings().size() <= 2) {
                    price = 45;
                } else {
                    price = 50;
                }
                if (pizza.getDough() == CEREAL) {
                    price += 10;
                }
                break;
        }

        return price;
    }

    private static double getMeatToppingsPercentage(List<Topping> toppings) {
        long count = toppings.stream()
                .filter(Topping::isMeat)
                .count();
        return ((double) count / (double) toppings.size()) * 100;
    }

    private Pizza addPizza() {
        try (Scanner in = new Scanner(System.in)) {
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

            Pizza pizza = pizzaBuilder
                    .withDough(dough)
                    .withSauce(sauce)
                    .withName(name)
                    .withSize(size)
                    .build();

            System.out.println(pizza);
            return pizza;
        }
    }
}
