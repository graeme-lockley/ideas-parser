package idea.parser;

public class Lexer {
    public static final char EOS = (char) 0;

    private final String input;
    private final int index;

    public Lexer(String input) {
        this(input, 0);
    }

    public Lexer(String input, int index) {
        this.input = input;
        this.index = index;
    }

    public char head() {
        return input.charAt(index);
    }

    public Lexer skip() {
        return new Lexer(input, index+1);
    }
}
