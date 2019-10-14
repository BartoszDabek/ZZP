package bi.zzp.builder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Dough {

    private final String type;

    public static Dough valueOf(String type) {
        return new Dough(type);
    }
}
