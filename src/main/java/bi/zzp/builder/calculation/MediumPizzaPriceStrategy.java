package bi.zzp.builder.calculation;

import bi.zzp.builder.PriceStrategy;
import bi.zzp.builder.model.Pizza;

import static bi.zzp.builder.calculation.PriceCalculatorUtil.getMeatToppingsPercentage;

public class MediumPizzaPriceStrategy implements PriceStrategy {

    @Override
    public int calculate(Pizza pizza) {
        int price;
        if (pizza.getToppings().size() <= 3) {
            if (getMeatToppingsPercentage(pizza.getToppings()) < 50) {
                price = 25;
            } else {
                price = 27;
            }
        } else {
            if (getMeatToppingsPercentage(pizza.getToppings()) < 40) {
                price = 27;
            } else {
                price = 29;
            }
        }
        return price;
    }

}
