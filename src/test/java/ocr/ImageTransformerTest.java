package ocr;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ImageTransformerTest {
    private final String imageFileName = "image.jpg";
    private final String savedFileName = "savedImage.jpg";

    private Image inputImage;
    private File savedFile;

    @Before
    public void setUp() throws Exception {
        final String folderToSave = getClass().getResource("/").getFile();
        final File imageFile = new File(folderToSave, imageFileName);
        savedFile = new File(folderToSave, savedFileName);

        inputImage = new Image(imageFile);
    }

    @Test
    public void scale() throws Exception {
        final int scalePercent = 50;

        final ImageTransformer transformer = new ImageTransformer(inputImage);
        final Image scaledImage = transformer.scale(scalePercent);

        assertThat(scaledImage.getWidth(), is(inputImage.getWidth() / 2));
        assertThat(scaledImage.getHeight(), is(inputImage.getHeight() / 2));
    }

    @After
    public void tearDown() throws Exception {
        savedFile.delete();
        assertThat(savedFile.exists(), is(false));
    }
}
