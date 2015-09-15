package idea.parser;

import java.util.Optional;

public class IntegerParser extends SequenceParser<Optional<Boolean>, Integer, Integer> {
    /*
        Minus?  Digit+
     */

    public IntegerParser() {
        super(new OptionalThing<>(new Minus()), new Digit(), (Optional<Boolean> v1, Integer v2) -> v1.isPresent() ? -v2 : v2);
    }
}
