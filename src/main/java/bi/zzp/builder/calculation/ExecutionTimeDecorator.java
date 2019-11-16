package bi.zzp.builder.calculation;

import bi.zzp.builder.model.Pizza;

public class ExecutionTimeDecorator implements CalculationStrategy {

    private final CalculationStrategy decorated;

    public ExecutionTimeDecorator(CalculationStrategy decorated) {
        this.decorated = decorated;
    }

    @Override
    public int calculate(Pizza pizza) {
        long before = System.nanoTime();
        int price = decorated.calculate(pizza);
        long after = System.nanoTime();

        System.out.println("Calculation time with system nanoTime= " + (after - before));

        return price;
    }
}
