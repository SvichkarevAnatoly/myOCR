package ocr;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ImageTest {
    private final String inputImageFileName = "image.jpg";
    private final String outputImageFileName = "savedImage.jpg";

    private Image inputImage;
    private File outputImageFile;

    @Rule
    public final TemporaryFolder tempFolder = new TemporaryFolder();

    @Before
    public void setUp() throws Exception {
        final String root = getClass().getResource("/").getFile();
        final File inputImageFile = new File(root, inputImageFileName);
        inputImage = new Image(inputImageFile);
        outputImageFile = new File(tempFolder.getRoot(), outputImageFileName);
    }

    @Test
    public void save() throws Exception {
        assertThat(outputImageFile.exists(), is(false));
        inputImage.save(outputImageFile);
        assertThat(outputImageFile.exists(), is(true));
    }

    @Test
    public void getWidth() throws Exception {
        assertThat(inputImage.getWidth(), is(414));
    }

    @Test
    public void getHeight() throws Exception {
        assertThat(inputImage.getHeight(), is(512));
    }
}
