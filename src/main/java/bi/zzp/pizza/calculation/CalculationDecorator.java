package bi.zzp.pizza.calculation;

public abstract class CalculationDecorator implements CalculationStrategy {
    final CalculationStrategy decorated;

    protected CalculationDecorator(CalculationStrategy decorated) {
        this.decorated = decorated;
    }
}
