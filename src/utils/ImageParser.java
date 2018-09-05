package utils;

import java.awt.image.BufferedImage;

public class ImageParser {


    public BufferedImage matrixToImage(int [][] imageMatrix){

        int height = imageMatrix.length;
        int width = imageMatrix[0].length;
        
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for(int y=0; y<height; y++) {
            for (int x = 0; x < width; x++) {
                bufferedImage.setRGB(x, y, imageMatrix[y][x]);
            }
        }
        return bufferedImage;
    }
}
