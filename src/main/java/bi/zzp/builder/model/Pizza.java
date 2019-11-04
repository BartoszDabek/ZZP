package bi.zzp.builder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Pizza {
    private final Dough dough;
    private final Sauce sauce;
    private final List<Topping> toppings;
    private final String name;
    private final Size size;
}
