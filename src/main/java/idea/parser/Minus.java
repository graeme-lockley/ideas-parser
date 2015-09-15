package idea.parser;

public class Minus extends Thing<Lexer, Either<String, Tuple<Lexer, Boolean>>> {
    @Override
    public boolean canParse(Lexer input) {
        return input.head() == '-';
    }

    @Override
    public Either<String, Tuple<Lexer, Boolean>> parse(Lexer input) {
        if (canParse(input)) {
            return Either.right(Tuple.from(input.skip(), true));
        } else {
            return Either.left("Parsing error: expected '-'");
        }
    }
}
