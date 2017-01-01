package ocr;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ImageTransformerTest {
    private final String inputImageFileName = "image.jpg";
    private Image inputImage;

    @Before
    public void setUp() throws Exception {
        final String folderToSave = getClass().getResource("/").getFile();
        final File inputImageFile = new File(folderToSave, inputImageFileName);
        inputImage = new Image(inputImageFile);
    }

    @Test
    public void scale() throws Exception {
        final int scalePercent = 50;

        final ImageTransformer transformer = new ImageTransformer(inputImage);
        final Image scaledImage = transformer.scale(scalePercent);

        assertThat(scaledImage.getWidth(), is(inputImage.getWidth() / 2));
        assertThat(scaledImage.getHeight(), is(inputImage.getHeight() / 2));
    }

    @Test
    public void toGray() throws Exception {
        // TODO:
        final ImageTransformer transformer = new ImageTransformer(inputImage);
        final Image grayImage = transformer.toGray();
    }
}
