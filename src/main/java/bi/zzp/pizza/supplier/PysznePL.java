package bi.zzp.pizza.supplier;

import bi.zzp.pizza.model.Pizza;
import lombok.Value;

@Value
public class PysznePL implements AbstractSupplier {

    public PysznePL() {
        super();
    }

    @Override
    public void update(Pizza pizza, String clientAddress, int price) {
        deliverToClient(pizza, clientAddress, price);
    }
}
