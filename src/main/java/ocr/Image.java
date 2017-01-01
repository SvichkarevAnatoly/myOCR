package ocr;

import org.bytedeco.javacpp.opencv_core.IplImage;

import java.io.File;

import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;

public class Image {
    private IplImage iplImage;

    public Image(File imageFile) {
        load(imageFile);
    }

    Image(IplImage iplImage) {
        this.iplImage = iplImage;
    }

    public IplImage getImage() {
        return iplImage;
    }

    public int getWidth() {
        return iplImage.width();
    }

    public int getHeight() {
        return iplImage.height();
    }

    public void save(File file) {
        final String imageFilePath = file.getAbsolutePath();
        cvSaveImage(imageFilePath, iplImage);
    }

    private void load(File imageFile) {
        final String imageFilePath = imageFile.getAbsolutePath();
        iplImage = cvLoadImage(imageFilePath);
    }
}
