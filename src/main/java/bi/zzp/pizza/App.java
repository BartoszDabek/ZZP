package bi.zzp.pizza;

import bi.zzp.pizza.model.Pizzeria;
import bi.zzp.pizza.supplier.PysznePL;
import bi.zzp.pizza.supplier.UberEats;

public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        UberEats uberEats = new UberEats();
        PysznePL pysznePL = new PysznePL();
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.add(uberEats);
        pizzeria.add(pysznePL);

        pizzeria.createPizzaForSupplierDelivery("12 Street");
        pizzeria.createPizzaForSupplierDelivery("13 Street");
        pizzeria.createPizzaForSupplierDelivery("14 Street");
    }
}
