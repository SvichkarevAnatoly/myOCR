package ocr;

import org.bytedeco.javacpp.opencv_core.CvSize;
import org.bytedeco.javacpp.opencv_core.IplImage;

import java.io.File;

import static org.bytedeco.javacpp.opencv_core.cvCreateImage;
import static org.bytedeco.javacpp.opencv_core.cvSize;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvLoadImage;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;
import static org.bytedeco.javacpp.opencv_imgproc.cvResize;

public class Image {
    private IplImage iplImage;

    public Image(File imageFile) {
        load(imageFile);
    }

    private Image() {
    }

    public IplImage getImage() {
        return iplImage;
    }

    public void setImage(IplImage iplImage) {
        this.iplImage = iplImage;
    }

    public int getWidth() {
        return iplImage.width();
    }

    public int getHeight() {
        return iplImage.height();
    }

    public void load(File imageFile) {
        final String imageFilePath = imageFile.getAbsolutePath();
        iplImage = cvLoadImage(imageFilePath);
    }

    public void save(File file) {
        final String imageFilePath = file.getAbsolutePath();
        cvSaveImage(imageFilePath, iplImage);
    }

    public Image scale(int percent) {
        final int newWidth = iplImage.width() * percent / 100;
        final int newHeight = iplImage.height() * percent / 100;
        final CvSize newSize = cvSize(newWidth, newHeight);

        final IplImage scaledIplImage = cvCreateImage(newSize, iplImage.depth(), iplImage.nChannels());
        cvResize(iplImage, scaledIplImage);

        final Image scaledImage = new Image();
        scaledImage.setImage(scaledIplImage);

        return scaledImage;
    }
}
