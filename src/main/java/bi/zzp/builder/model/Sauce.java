package bi.zzp.builder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Sauce {

    private final String type;

    public static Sauce valueOf(String type) {
        return new Sauce(type);
    }
}
