package bi.zzp.pizza.calculation;

import bi.zzp.pizza.model.Pizza;

import static bi.zzp.pizza.model.Dough.CEREAL;

public class ExtraPizzaPriceCalculator implements CalculationStrategy {

    @Override
    public int calculate(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 2) {
            price = 45;
        } else {
            price = 50;
        }
        if (pizza.getDough() == CEREAL) {
            price += 10;
        }
        return price;
    }

}
