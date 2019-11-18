package bi.zzp.builder.calculation;

import bi.zzp.builder.PriceStrategy;
import bi.zzp.builder.model.Pizza;
import bi.zzp.builder.model.Size;

public class PriceCalculator {

    public int calculatePrice(Pizza pizza) {
        Size size = pizza.getSize();

        PriceStrategy priceCalculator = switch (size) {
            case SMALL -> new SmallPizzaPriceStrategy();
            case MEDIUM -> new MediumPizzaPriceStrategy();
            case LARGE -> new LargePizzaPriceStrategy();
            case EXTRA -> new ExtraLargePizzaPriceStrategy();
        };

        return priceCalculator.calculate(pizza);
    }
}
