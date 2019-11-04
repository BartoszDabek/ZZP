package bi.zzp.builder;

import bi.zzp.builder.model.Topping;

import java.util.List;

class PriceCalculatorUtil {

    static double getMeatToppingsPercentage(List<Topping> toppings) {
        long count = toppings.stream()
                .filter(Topping::isMeat)
                .count();
        return ((double) count / (double) toppings.size()) * 100;
    }
}
