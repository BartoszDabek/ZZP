package bi.zzp.pizza.calculation;

import bi.zzp.pizza.model.Pizza;

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
