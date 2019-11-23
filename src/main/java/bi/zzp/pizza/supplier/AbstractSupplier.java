package bi.zzp.pizza.supplier;

import bi.zzp.pizza.model.Observer;
import bi.zzp.pizza.model.Pizza;

public interface AbstractSupplier extends Observer {

    default void deliverToClient(Pizza pizza, String clientAddress, int price) {
        System.out.println("Pizza " + pizza.toString() + " is ready to being delivered to the client at " + clientAddress + ". Pizza cost = " + price);
    }

}
