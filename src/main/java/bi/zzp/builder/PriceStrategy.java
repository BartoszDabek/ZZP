package bi.zzp.builder;

import bi.zzp.builder.model.Pizza;

public interface PriceStrategy {

    int calculate(Pizza pizza);

}
