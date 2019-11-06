package bi.zzp.builder.calculation;

import bi.zzp.builder.model.Pizza;

public interface CalculationStrategy {

    int calculate(Pizza pizza);
}
