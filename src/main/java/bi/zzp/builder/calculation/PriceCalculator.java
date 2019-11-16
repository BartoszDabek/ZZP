package bi.zzp.builder.calculation;

import bi.zzp.builder.model.Pizza;
import bi.zzp.builder.model.Size;

public class PriceCalculator {

    public int calculatePrice(Pizza pizza) {
        Size size = pizza.getSize();

        CalculationStrategy priceCalculator = getStrategy(size);

        int price = priceCalculator.calculate(pizza);

        System.out.println("Price = " + price);
        return price;
    }

    private CalculationStrategy getStrategy(Size size) {
        return new LoggingDecorator(
                new ExecutionTimeDecorator(switch (size) {
                    case SMALL -> new SmallPizzaPriceCalculator();
                    case MEDIUM -> new MediumPizzaPriceCalculator();
                    case LARGE -> new LargePizzaPriceCalculator();
                    case EXTRA -> new ExtraPizzaPriceCalculator();
                })
        );
    }

}
