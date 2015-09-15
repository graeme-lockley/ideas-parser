package idea.parser;

import java.util.function.BiFunction;

public abstract class SequenceParser <A, B, C> extends Thing<Lexer, Either<String, Tuple<Lexer, C>>> {
    protected final Thing<Lexer, Either<String, Tuple<Lexer, A>>> first;
    protected final Thing<Lexer, Either<String, Tuple<Lexer, B>>> second;
    private BiFunction<A, B, C> mergeFunction;

    public SequenceParser(Thing<Lexer, Either<String, Tuple<Lexer, A>>> first, Thing<Lexer, Either<String, Tuple<Lexer, B>>> second, BiFunction<A, B, C> mergeFunction) {
        this.first = first;
        this.second = second;
        this.mergeFunction = mergeFunction;
    }

    @Override
    public boolean canParse(Lexer input) {
        return false;
    }

    @Override
    public Either<String, Tuple<Lexer, C>> parse(Lexer input) {
        final Either<String, Tuple<Lexer, A>> firstResponse = first.parse(input);

        if (firstResponse.isLeft()) {
            return Either.left(firstResponse.left());
        } else {
            final Either<String, Tuple<Lexer, B>> secondResponse = second.parse(firstResponse.right().v1);

            if (secondResponse.isLeft()) {
                return Either.left(secondResponse.left());
            } else {
                return Either.right(Tuple.from(secondResponse.right().v1, mergeFunction.apply(firstResponse.right().v2, secondResponse.right().v2)));
            }
        }
    }
}
