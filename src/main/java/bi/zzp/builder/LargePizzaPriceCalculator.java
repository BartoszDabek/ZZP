package bi.zzp.builder;

import bi.zzp.builder.model.Pizza;

import static bi.zzp.builder.PriceCalculatorUtil.getMeatToppingsPercentage;
import static bi.zzp.builder.model.Dough.CEREAL;
import static bi.zzp.builder.model.Topping.ANANAS;

public class LargePizzaPriceCalculator implements PriceCalculator {

    @Override
    public int calculate(Pizza pizza) {
        int price = 0;
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
        return price;
    }

}
