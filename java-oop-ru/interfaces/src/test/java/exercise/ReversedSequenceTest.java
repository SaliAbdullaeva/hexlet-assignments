package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

public class ReversedSequenceTest {
    @Test
    public void testToString() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals("fedcba", text.toString());
    }

    @Test
    public void testCharAt() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals('e', text.charAt(1));
    }

    @Test
    public void testLength() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals(6, text.length());
    }

    @Test
    public void testSubSequence() {
        CharSequence text = new ReversedSequence("abcdef");
        assertEquals("edc", text.subSequence(1, 4).toString());
    }
}
