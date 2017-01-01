package ocr;

import org.bytedeco.javacpp.opencv_core.IplImage;

import java.io.File;

import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;

public class Image {
    private IplImage iplImage;

    public Image() {}

    public Image(File imageFile) {
        load(imageFile);
    }

    public IplImage getImage() {
        return iplImage;
    }

    public void setImage(IplImage iplImage) {
        this.iplImage = iplImage;
    }

    public void load(File imageFile) {
        final String imageFilePath = imageFile.getAbsolutePath();
        iplImage = cvLoadImage(imageFilePath);
    }

    public void save(File file) {
        final String imageFilePath = file.getAbsolutePath();
        cvSaveImage(imageFilePath, iplImage);
    }
}
