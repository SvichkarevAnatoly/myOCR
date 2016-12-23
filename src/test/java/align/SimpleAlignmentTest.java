package align;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleAlignmentTest {
    @Test
    public void nucleotides() throws Exception {
        final SimpleAlignment alignment = new SimpleAlignment(1, 1);
        assertThat(alignment.align("ACT", "ATT"), is(1));
    }

    @Test
    public void englishWords() throws Exception {
        final SimpleAlignment alignment = new SimpleAlignment(1, 1);
        final String v = "PLEASANTLY";
        final String w = "MEANLY";
        assertThat(alignment.align(v, w), is(0));
    }
}
