package idea.parser;

public class Minus extends Thing<Lexer, Either<String, Tuple<Lexer, Integer>>> {
    @Override
    public boolean canParse(Lexer input) {
        return input.head() == '-';
    }

    @Override
    public Either<String, Tuple<Lexer, Integer>> parse(Lexer input) {
        if (canParse(input)) {
            return Either.right(Tuple.from(input.skip(), -1));
        } else {
            return Either.left("Parsing error: expected '-'");
        }
    }
}
