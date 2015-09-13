package idea.parser;

public class Digit extends Thing<Lexer, Either<String, Tuple<Lexer, Integer>>> {
    @Override
    public boolean canParse(Lexer input) {
        return Character.isDigit(input.head());
    }

    @Override
    public Either<String, Tuple<Lexer, Integer>> parse(Lexer input) {
        if (canParse(input)) {
            return Either.right(Tuple.from(input.skip(), ((int) input.head()) - ((int) '0')));
        } else {
            return Either.left("Parsing error: expected digit");
        }
    }
}
