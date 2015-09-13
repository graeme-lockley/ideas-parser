package idea.parser;

public class IntegerParser extends SequenceParser<Integer, Integer, Integer> {
    /*
        Minus?  Digit+
     */

    public IntegerParser() {
        super(new Minus(), new Digit(), (Integer v1, Integer v2) -> v1 * v2);
    }
}
