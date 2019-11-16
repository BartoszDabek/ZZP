package bi.zzp.builder.calculation;

import bi.zzp.builder.model.Pizza;
import bi.zzp.builder.model.Size;

public class PriceCalculator {

    public int calculatePrice(Pizza pizza) {
        Size size = pizza.getSize();

        CalculationStrategy priceCalculator = switch (size) {
            case SMALL -> new SmallPizzaPriceCalculator();
            case MEDIUM -> new MediumPizzaPriceCalculator();
            case LARGE -> new LargePizzaPriceCalculator();
            case EXTRA -> new ExtraPizzaPriceCalculator();
        };

        System.out.println("Calculation strategy = " + priceCalculator.getClass().getSimpleName() + " invoked.");
        long before = System.nanoTime();
        int price = priceCalculator.calculate(pizza);
        long after = System.nanoTime();

        System.out.println("Calculation time with system nanoTime= " + (after - before));
        return price;
    }

}
