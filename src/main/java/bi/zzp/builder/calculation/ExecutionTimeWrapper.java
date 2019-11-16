package bi.zzp.builder.calculation;

import bi.zzp.builder.model.Pizza;

public class ExecutionTimeWrapper {

    private final CalculationStrategy priceCalculator;

    public ExecutionTimeWrapper(CalculationStrategy priceCalculator) {
        this.priceCalculator = priceCalculator;
    }

    int calculate(Pizza pizza) {
        long before = System.nanoTime();
        int price = priceCalculator.calculate(pizza);
        long after = System.nanoTime();

        System.out.println("Calculation time with system nanoTime= " + (after - before));

        return price;
    }
}
