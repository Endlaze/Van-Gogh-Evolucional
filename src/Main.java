import adaptability.adaptability_ut.Test_Euclidean;
import adaptability.adaptability_ut.Test_MSE;
import geneticAlgorithm.Individual;
import gui.ShowPictureGUI;
import utils.ImageParser;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //Tests
        Test_MSE.testMSE();
        Test_Euclidean.testMSE();

    }
    public void testComponents(){
        Individual individual = new Individual(1024,1024);
        System.out.println(Arrays.deepToString(individual.genes));
        ImageParser parser = new ImageParser();

        BufferedImage bufferedImage = parser.matrixToImage(individual.genes);

        int [][] test = parser.imageToMatrix(bufferedImage);
        System.out.println(Arrays.deepToString(test));

        ShowPictureGUI gui = new ShowPictureGUI();
        gui.ShowPicture(bufferedImage);
    }
}
