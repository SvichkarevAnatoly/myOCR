package ocr;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.IplImage;

public class Main {
    public static void main(String[] args) {
        // set working directory to resource
        final ReceiptScannerImpl scanner = new ReceiptScannerImpl();
        final IplImage image = scanner.loadImage("receipt.jpg");
        
        final IplImage smallImage = scanner.downScaleImage(image, 30);
        scanner.saveImage(smallImage, "smallReceipt.jpg");

        final IplImage cannyImage = scanner.applyCannySquareEdgeDetectionOnImage(image);
        scanner.saveImage(cannyImage, "cannyReceipt.jpg");

        final opencv_core.CvSeq contour = scanner.findLargestSquareOnCannyDetectedImage(cannyImage);
        final IplImage rotatedImage = scanner.applyPerspectiveTransformThresholdOnOriginalImage(image, contour);
        scanner.saveImage(rotatedImage, "rotatedReceipt.jpg");

        final IplImage prismaImage = scanner.loadImage("prisma.jpg");
        final IplImage cleanedImage = scanner.cleanImageSmoothingForOCR(prismaImage);
        scanner.saveImage(cleanedImage, "cleanedPrisma.jpg");

        final String textFromReceiptImage = scanner.getStringFromImage("cleanedPrisma.jpg");
        System.out.println(textFromReceiptImage);
    }
}
