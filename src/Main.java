import fitness.fitness_ut.Test_Euclidean;
import fitness.fitness_ut.Test_MSE;
import geneticAlgorithm.Individual;
import geneticAlgorithm.Population;
import gui.ShowPictureGUI;
import utils.ImageParser;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        //Tests
        Test_MSE.testMSE();
        Test_Euclidean.testMSE();
        Population population = new Population(1000000, 5,5);


        population.populationCrossover(100,100);


    }
    public void testComponents(){
        Individual individual = new Individual(5,5);
        System.out.println(Arrays.deepToString(individual.getGenes()));
        ImageParser parser = new ImageParser();

        BufferedImage bufferedImage = parser.matrixToImage(individual.getGenes());

        int [][] test = parser.imageToMatrix(bufferedImage);
        System.out.println(Arrays.deepToString(test));

        ShowPictureGUI gui = new ShowPictureGUI();
        gui.ShowPicture(bufferedImage);
    }
}
