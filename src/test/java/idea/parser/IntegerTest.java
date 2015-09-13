package idea.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegerTest {
    @Test
    public void should_parse_a_negative_integer() throws Exception {
        final Either<String, Tuple<Lexer, Integer>> parse = new IntegerParser().parse(new Lexer("-23A"));

        assertTrue(parse.isRight());
        assertEquals(-23, parse.right().v2.intValue());
        assertEquals('A', parse.right().v1.head());
    }

    @Test
    public void should_parse_a_positive_integer() throws Exception {
        final Either<String, Tuple<Lexer, Integer>> parse = new IntegerParser().parse(new Lexer("23A"));

        assertTrue(parse.isRight());
        assertEquals(23, parse.right().v2.intValue());
        assertEquals('A', parse.right().v1.head());
    }

    @Test
    public void should_fail_parsing_on_an_invalid_integer() throws Exception {
        final Either<String, Tuple<Lexer, Integer>> parse = new IntegerParser().parse(new Lexer("-A"));

        assertTrue(parse.isLeft());
    }
}
