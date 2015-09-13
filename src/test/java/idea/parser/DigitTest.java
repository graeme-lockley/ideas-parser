package idea.parser;

import org.junit.Test;

import static org.junit.Assert.*;

public class DigitTest {
    @Test
    public void should_parse_a_digit() throws Exception {
        final Either<String, Tuple<Lexer, Integer>> parse = new Digit().parse(new Lexer("123"));

        assertEquals(1, parse.right().v2.intValue());
        assertEquals('2', parse.right().v1.head());
    }

    @Test
    public void should_not_parse_an_invalid_digit() throws Exception {
        final Either<String, Tuple<Lexer, Integer>> parse = new Digit().parse(new Lexer("-23"));

        assertTrue(parse.isLeft());
    }
}