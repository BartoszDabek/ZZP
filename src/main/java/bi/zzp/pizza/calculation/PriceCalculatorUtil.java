package bi.zzp.pizza.calculation;

import bi.zzp.pizza.model.Topping;

import java.util.List;

class PriceCalculatorUtil {

    static double getMeatToppingsPercentage(List<Topping> toppings) {
        long count = toppings.stream()
                .filter(Topping::isMeat)
                .count();
        return ((double) count / (double) toppings.size()) * 100;
    }
}
