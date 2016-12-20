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
}
