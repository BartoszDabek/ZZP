package bi.zzp.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Dough {

    public final static Dough CEREAL = new Dough("CEREAL");
    private final String type;

    public static Dough valueOf(String type) {
        return new Dough(type);
    }
}
