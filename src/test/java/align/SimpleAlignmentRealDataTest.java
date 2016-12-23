package align;

import org.junit.Test;

public class SimpleAlignmentRealDataTest {
    @Test
    public void chicken() throws Exception {
        final String ocr = "[114ЛЕ Б/К0ЖИ К9РИН0Е 0ХЛ. НА П0187. ММ 187. И";
        final String real = "ФИЛЕ Б/КОЖИ КУРИНОЕ ОХЛ. НА ПО187. 14*1   187. 14";
        final SimpleAlignment alignment = new SimpleAlignment(20, 1, 100);

        System.out.println("score = " + alignment.align(ocr, real));
        // assertThat(alignment.align(ocr, real), is(-182));

        System.out.println(alignment.getAlignString1());
        System.out.println(alignment.getAlignString2());
        // assertThat(alignment.getAlignString1(), is(ocr));
        // assertThat(alignment.getAlignString2(), is(real));

        alignment.printScoreMatrix();
    }

    @Test
    public void chickenShort() throws Exception {
        final String ocr = "К0ЖИВВ";
        final String real = "КОЖИ";
        final SimpleAlignment alignment = new SimpleAlignment(20, 1, 100);

        System.out.println("score = " + alignment.align(ocr, real));
        // assertThat(alignment.align(ocr, real), is(-182));

        alignment.printScoreMatrix();
        alignment.printBacktrack();

        System.out.println(alignment.getAlignString1());
        System.out.println(alignment.getAlignString2());
        // assertThat(alignment.getAlignString1(), is(ocr));
        // assertThat(alignment.getAlignString2(), is(real));
    }
}
