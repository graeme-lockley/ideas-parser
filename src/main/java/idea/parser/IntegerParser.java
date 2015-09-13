package idea.parser;

public class IntegerParser extends SequenceParser<Lexer, Either<String, Tuple<Lexer, Integer>>, Either<String, Tuple<Lexer, Integer>>, Lexer> {
    /*
        Minus?  Digit+
     */

    public IntegerParser() {
        super(new Minus(), new Digit());
    }

    @Override
    public Either<String, Tuple<Lexer, Integer>> parse(Lexer input) {
        final Either<String, Tuple<Lexer, Integer>> firstResponse = first.parse(input);

        if (firstResponse.isLeft()) {
            return firstResponse;
        } else {
            final Either<String, Tuple<Lexer, Integer>> secondResponse = second.parse(firstResponse.right().v1);

            if (secondResponse.isLeft()) {
                return secondResponse;
            } else {
                return Either.right(Tuple.from(secondResponse.right().v1, firstResponse.right().v2 * secondResponse.right().v2));
            }
        }
    }
}
