package bi.zzp.builder.calculation;

import bi.zzp.builder.model.Pizza;

public class ExecutionTimeDecorator extends CalculationDecorator {

    public ExecutionTimeDecorator(CalculationStrategy decorated) {
        super(decorated);
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
