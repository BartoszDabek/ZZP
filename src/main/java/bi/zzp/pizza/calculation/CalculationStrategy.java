package bi.zzp.pizza.calculation;

import bi.zzp.pizza.model.Pizza;

public interface CalculationStrategy {

    int calculate(Pizza pizza);
}
