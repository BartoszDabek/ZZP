package bi.zzp.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Topping {

    public static final Topping ANANAS = new Topping("ANANAS");
    private static final List<String> meats = List.of("Ham", "Meat", "Chicken");
    private final String name;

    public static Topping valueOf(String name) {
        return new Topping(name);
    }

    public static boolean isMeat(Topping topping) {
        return meats.contains(topping.name);
    }
}
