package bi.zzp.pizza.calculation;

import bi.zzp.pizza.model.Pizza;

public class SmallPizzaPriceCalculator implements CalculationStrategy {

    @Override
    public int calculate(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 2) {
            price = 18;
        } else {
            price = 22;
        }
        return price;
    }
}
