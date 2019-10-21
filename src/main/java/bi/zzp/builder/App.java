package bi.zzp.builder;

import bi.zzp.builder.model.Pizza;
import bi.zzp.builder.model.PizzaBuilder;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        addPizza();
    }

    private void addPizza() {
        try (Scanner in = new Scanner(System.in)) {
            PizzaBuilder pizzaBuilder = new PizzaBuilder();
            System.out.println("What type of dough do you want? (ITALIAN, POLISH, AMERICAN)");
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
        }
    }
}
