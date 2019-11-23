package bi.zzp.pizza.supplier;

import bi.zzp.pizza.model.Pizza;
import lombok.Value;

@Value
public class UberEats implements Supplier {

    public UberEats() {
        super();
    }

    @Override
    public void update(Pizza pizza, String clientAddress, int price) {
        deliverToClient(pizza, clientAddress, price);
    }

}
