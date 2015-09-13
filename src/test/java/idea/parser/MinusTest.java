package idea.parser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MinusTest {
    @Test
    public void should_parse_a_minus_successfully() throws Exception {
        Minus minus = new Minus();
        Lexer lexer = new Lexer("-123");

        final Either<String, Tuple<Lexer, Integer>> parse = minus.parse(lexer);

        assertEquals(parse.right().v1.head(), '1');
        assertEquals(parse.right().v2.intValue(), -1);
    }

    @Test
    public void should_not_be_able_parse_a_minus() throws Exception {
        Minus minus = new Minus();
        Lexer lexer = new Lexer("123");

        final Either<String, Tuple<Lexer, Integer>> parse = minus.parse(lexer);

        assertTrue(parse.isLeft());
    }
}
