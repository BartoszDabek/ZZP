package bi.zzp.pizza.calculation;

import bi.zzp.pizza.model.Pizza;

import static bi.zzp.pizza.calculation.PriceCalculatorUtil.getMeatToppingsPercentage;

public class MediumPizzaPriceCalculator implements CalculationStrategy {

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
