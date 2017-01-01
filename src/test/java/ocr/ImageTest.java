package ocr;

import org.junit.After;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ImageTest {
    private final String imageFileName = "image.jpg";
    private final String savedFileName = "savedImage.jpg";

    private final String folderToSave = getClass().getResource("/").getFile();
    private final File imageFile = new File(folderToSave, imageFileName);
    private final File savedFile = new File(folderToSave, savedFileName);


    @Test
    public void constructorAndSave() throws Exception {
        assertThat(imageFile.exists(), is(true));

        final Image image = new Image(imageFile);

        assertThat(savedFile.exists(), is(false));
        image.save(savedFile);
        assertThat(savedFile.exists(), is(true));
    }

    @Test
    public void loadAndSave() throws Exception {
        assertThat(imageFile.exists(), is(true));

        final Image image = new Image();
        image.load(imageFile);

        assertThat(savedFile.exists(), is(false));
        image.save(savedFile);
        assertThat(savedFile.exists(), is(true));
    }


    @After
    public void tearDown() throws Exception {
        savedFile.delete();
        assertThat(savedFile.exists(), is(false));
    }
}
