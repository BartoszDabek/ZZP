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
            Dough dough = Dough.valueOf(in.nextLine());

            System.out.println("What type of sauce? (GARLIC, BBQ, CHILI)");
            Sauce sauce = Sauce.valueOf(in.nextLine());

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

            Pizza pizza = new Pizza(dough, sauce, toppings);
            System.out.println(pizza);
        }
    }
}
