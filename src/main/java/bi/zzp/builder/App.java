package bi.zzp.builder;

import bi.zzp.builder.model.Dough;
import bi.zzp.builder.model.Pizza;
import bi.zzp.builder.model.Sauce;
import bi.zzp.builder.model.Topping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        addPizza();
    }

    private void addPizza() {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("What type of dough do you want? (ITALIAN, POLISH, AMERICAN)");
            String doughValue = in.nextLine();
            if (doughValue.isBlank()) {
                doughValue = "italian";
            }
            Dough dough = Dough.valueOf(doughValue);

            System.out.println("What type of sauce? (GARLIC, BBQ, CHILI)");
            String sauceValue = in.nextLine();
            if (sauceValue.isBlank()) {
                sauceValue = "bbq";
            }
            Sauce sauce = Sauce.valueOf(sauceValue);

            System.out.println("What pizza do you want? (Firm, Margherita, Chicken, etc..)");
            String name = in.nextLine();
            if (name.isBlank()) {
                name = "margherita";
            }

            System.out.println("What size of pizza? (SMALL, MEDIUM, LARGE, EXTRA)");
            String size = in.nextLine();
            if (size.isBlank()) {
                size = "medium";
            }

            List<Topping> toppings = new ArrayList<>();
            while (true) {
                System.out.println("What topping do you want?");
                toppings.add(Topping.valueOf(in.nextLine()));

                System.out.println("Next topping? (YES/NO)");
                String nextTopping = in.nextLine();

                if ("NO".equalsIgnoreCase(nextTopping)) {
                    break;
                }
            }

            Pizza pizza = new Pizza(dough, sauce, toppings, name, size);
            System.out.println(pizza);
        }
    }
}
