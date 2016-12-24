package align;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleAlignmentRealDataTest {
    @Test
    public void chicken() throws Exception {
        final String ocr = "[114ЛЕ Б/К0ЖИ К9РИН0Е 0ХЛ. НА П0187. ММ 187. И";
        final String real = "ФИЛЕ Б/КОЖИ КУРИНОЕ ОХЛ. НА ПО187. 14*1   187. 14";
        final SimpleAlignment alignment = new SimpleAlignment();

        System.out.println("score = " + alignment.align(ocr, real));
        assertThat(alignment.align(ocr, real), is(17));

        // alignment.printScoreMatrix();
        // alignment.printBacktrack();

        System.out.println(alignment.getAlignString1());
        System.out.println(alignment.getAlignString2());

        final String expectedAlignStr1 = "[114ЛЕ Б/К0ЖИ К9РИН0Е 0ХЛ. НА П0187. ММ-- --187. И-";
        final String expectedAlignStr2 = "ФИ--ЛЕ Б/КОЖИ КУРИНОЕ ОХЛ. НА ПО187. 14*1   187. 14";

        assertThat(alignment.getAlignString1(), is(expectedAlignStr1));
        assertThat(alignment.getAlignString2(), is(expectedAlignStr2));
    }

    @Test
    public void chickenWord() throws Exception {
        final String ocr = "К9РИН0Е";
        final String real = "КУРИНОЕ";
        final SimpleAlignment alignment = new SimpleAlignment();

        assertThat(alignment.align(ocr, real), is(498));

        System.out.println(alignment.getAlignString1());
        System.out.println(alignment.getAlignString2());

        alignment.printScoreMatrix();
        alignment.printBacktrack();

        assertThat(alignment.getAlignString1(), is(ocr));
        assertThat(alignment.getAlignString2(), is(real));
    }
}
