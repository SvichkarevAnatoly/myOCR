package ocr;

import org.bytedeco.javacpp.opencv_core.CvSize;
import org.bytedeco.javacpp.opencv_core.IplImage;

import static org.bytedeco.javacpp.opencv_core.cvCreateImage;
import static org.bytedeco.javacpp.opencv_core.cvSize;
import static org.bytedeco.javacpp.opencv_imgproc.cvResize;

public class ImageTransformer {
    private final Image image;

    public ImageTransformer(Image image) {
        this.image = image;
    }

    public Image scale(int percent) {
        final int newWidth = image.getWidth() * percent / 100;
        final int newHeight = image.getHeight() * percent / 100;
        final CvSize newSize = cvSize(newWidth, newHeight);

        final IplImage iplImage = this.image.getImage();
        final IplImage scaledIplImage = cvCreateImage(newSize,
                iplImage.depth(), iplImage.nChannels());
        cvResize(iplImage, scaledIplImage);

        final Image scaledImage = new Image(scaledIplImage);
        return scaledImage;
    }
}
