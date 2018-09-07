package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class ImageParser {


    public BufferedImage matrixToImage(int [][] imageMatrix){

        int height = imageMatrix.length;
        int width = imageMatrix[0].length;
        
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);

        for(int y=0; y<height; y++) {
            for (int x = 0; x < width; x++) {
                Color newColor = new Color(imageMatrix[y][x], imageMatrix[y][x], imageMatrix[y][x]);
                bufferedImage.setRGB(x,y,newColor.getRGB());
            }
        }
        return bufferedImage;
    }

    public int[][] imageToMatrix(BufferedImage image) {
        int bitmask = 0x000FF;
        final int width = image.getWidth();
        final int height = image.getHeight();
        int[][] result = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                result[j][i] = image.getRGB(i,j) & bitmask;
            }
        }
        return result;

    }

}

