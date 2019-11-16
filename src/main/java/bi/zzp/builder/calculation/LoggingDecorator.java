package bi.zzp.builder.calculation;

import bi.zzp.builder.model.Pizza;

public class LoggingDecorator implements CalculationStrategy {

    private final CalculationStrategy decorated;

    public LoggingDecorator(CalculationStrategy decorated) {
        this.decorated = decorated;
    }
    @Override
    public int calculate(Pizza pizza) {
        System.out.println("Calculation strategy = " + decorated.getClass().getSimpleName() + " invoked.");
        return decorated.calculate(pizza);
    }
}
