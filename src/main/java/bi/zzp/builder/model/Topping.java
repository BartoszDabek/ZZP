package bi.zzp.builder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Topping {

    private final String name;

    public static Topping valueOf(String name) {
        return new Topping(name);
    }
}
