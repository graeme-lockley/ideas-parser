package idea.parser;

public abstract class OptionalThing<I, O> extends Thing<I, O> {
    private final Thing<I, O> thing;

    public OptionalThing(Thing<I, O> thing) {
        this.thing = thing;
    }

    public abstract O otherwise(I input);

    public boolean canParse(I input) {
        return true;
    }

    public O parse(I input) {
        if (thing.canParse(input)) {
            return thing.parse(input);
        } else {
            return otherwise(input);
        }
    }
}
