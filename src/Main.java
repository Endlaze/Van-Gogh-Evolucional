import fitness.fitness_factory.FitnessFactory;
import fitness.fitness_factory.IFitness;
import fitness.fitness_ut.Test_Euclidean;
import fitness.fitness_ut.Test_MSE;
import fitness.fitness_utils.GrayScaleFilter;
import geneticAlgorithm.Population;
import gui.ShowPictureGUI;
import utils.FileManager;
import utils.ImageParser;
import utils.Sort;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        //Tests
        Test_MSE.testMSE();
        Test_Euclidean.testMSE();
        testComponents();

    }
    public static   void  testComponents(){
        FileManager toLoad = new FileManager();
        BufferedImage image = null;
        try
        {
            image = toLoad.ReadImage("mario.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        GrayScaleFilter filter = new GrayScaleFilter();
        filter.applyGrayScaleFilter(image);
        ShowPictureGUI gui = new ShowPictureGUI();
        gui.showPicture(image);
        ImageParser parser = new ImageParser();
        int [][] originalMatrix = parser.imageToMatrix(image);
        IFitness mseAlgorithm = FitnessFactory.getAdaptabilityAlgorithm("MSE");
        Population population = new Population(4,4,4);

        for (var individual: population.getIndividuals()) {
            System.out.println(Arrays.deepToString(individual.getGenes()));
        }

        for (var individual: population.getIndividuals()) {
            individual.fitness = mseAlgorithm.adaptabilityAlgorithm(individual.getGenes(),originalMatrix);
        }
        Arrays.sort(population.getIndividuals(), new Sort());

        for (var individual: population.getIndividuals()) {
            System.out.println(Arrays.deepToString(individual.getGenes()));
        }

    }
}
