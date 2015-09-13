package idea.parser;

public abstract class SequenceParser<I, O, A, B> extends Thing<I, O> {
    protected final Thing<I, A> first;
    protected final Thing<B, O> second;

    public SequenceParser(Thing<I, A> first, Thing<B, O> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean canParse(I input) {
        return first.canParse(input);
    }
}
