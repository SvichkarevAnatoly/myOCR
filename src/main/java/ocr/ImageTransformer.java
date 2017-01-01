package ocr;

import org.bytedeco.javacpp.opencv_core.CvSize;
import org.bytedeco.javacpp.opencv_core.IplImage;

import static org.bytedeco.javacpp.opencv_core.*;
import static org.bytedeco.javacpp.opencv_imgproc.CV_BGR2GRAY;
import static org.bytedeco.javacpp.opencv_imgproc.cvCvtColor;
import static org.bytedeco.javacpp.opencv_imgproc.cvResize;

public class ImageTransformer {
    // оригинал не изменяется
    private final Image image;
    private final IplImage iplImage;

    public ImageTransformer(Image image) {
        this.image = image;
        iplImage = this.image.getImage();
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

    public Image toGray() {
        final IplImage grayIplImage = cvCreateImage(iplImage.cvSize(), IPL_DEPTH_8U, 1);
        cvCvtColor(iplImage, grayIplImage, CV_BGR2GRAY);

        final Image grayImage = new Image(grayIplImage);
        return grayImage;
    }
}
