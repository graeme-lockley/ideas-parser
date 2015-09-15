package idea.parser;

import java.util.Optional;

public class OptionalThing<O> extends Thing<Lexer, Either<String, Tuple<Lexer, Optional<O>>>> {
    private final Thing<Lexer, Either<String, Tuple<Lexer, O>>> thing;

    public OptionalThing(Thing<Lexer, Either<String, Tuple<Lexer, O>>> thing) {
        this.thing = thing;
    }

    @Override
    public boolean canParse(Lexer input) {
        return thing.canParse(input);
    }

    @Override
    public Either<String, Tuple<Lexer, Optional<O>>> parse(Lexer input) {
        if (canParse(input)) {
            Either<String, Tuple<Lexer, O>> thingResult = thing.parse(input);
            return Either.right(Tuple.from(thingResult.right().v1, Optional.of(thingResult.right().v2)));
        } else {
            return Either.right(Tuple.<Lexer, Optional<O>>from(input, Optional.empty()));
        }
    }
}
