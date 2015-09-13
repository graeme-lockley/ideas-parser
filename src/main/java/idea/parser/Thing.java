package idea.parser;

public abstract class Thing<I, O> {
    public abstract boolean canParse(I input);

    public abstract O parse(I input);
}
