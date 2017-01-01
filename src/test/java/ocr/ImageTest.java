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
        final File inputImageFile = tempFolder.newFile(inputImageFileName);
        inputImage = new Image(inputImageFile);
        outputImageFile = new File(tempFolder.getRoot(), outputImageFileName);
    }

    @Test
    public void save() throws Exception {
        assertThat(outputImageFile.exists(), is(false));
        inputImage.save(outputImageFile);
        assertThat(outputImageFile.exists(), is(true));
    }
}
