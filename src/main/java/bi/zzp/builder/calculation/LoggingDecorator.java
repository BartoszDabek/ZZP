package bi.zzp.builder.calculation;

import bi.zzp.builder.model.Pizza;

public class LoggingDecorator extends CalculationDecorator {

    public LoggingDecorator(CalculationStrategy decorated) {
        super(decorated);
    }

    @Override
    public int calculate(Pizza pizza) {
        System.out.println("Calculation strategy = " + decorated.getClass().getSimpleName() + " invoked.");
        return decorated.calculate(pizza);
    }
}
