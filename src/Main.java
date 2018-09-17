import fitness.fitness_factory.FitnessFactory;
import fitness.fitness_factory.IFitness;
import fitness.fitness_ut.Test_Euclidean;
import fitness.fitness_ut.Test_MSE;
import fitness.fitness_utils.GrayScaleFilter;
import geneticAlgorithm.GeneticAlgorithm;
import geneticAlgorithm.Population;
import gui.GUI;
import gui.ShowPictureGUI;
import org.jfree.ui.RefineryUtilities;
import utils.FileManager;
import utils.ImageParser;
import utils.Sort;
import utils.XYSeriesDemo;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;


public class Main {


    public static void main(String[] args) throws IOException {
        //Tests
        Test_MSE.testMSE();
        Test_Euclidean.testMSE();
        //demo
        demo();

    }
    public static   void  demo() throws IOException{

        //Creating GUI
        GUI geneticGUI = new GUI();
        JFrame frame = new JFrame();
        frame.add(geneticGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //Waiting for user interaction

        while(geneticGUI.getStartGenetics() == false){
            System.out.println("Waiting to start...");

        }

        //Reads image from path
        FileManager toLoad = new FileManager();
        BufferedImage metaImage = null;
        metaImage = toLoad.ReadImage(geneticGUI.getImagePath());

        //Applying grayscale filter
        GrayScaleFilter filter = new GrayScaleFilter();
        filter.applyGrayScaleFilter(metaImage);

        geneticGUI.setMetaImageLabel(metaImage);

        String fitnessAlgorithm = geneticGUI.getFitnessAlgorithm();
        fitnessAlgorithm.toUpperCase();

        final XYSeriesDemo demo = new XYSeriesDemo(fitnessAlgorithm);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        long start = System.currentTimeMillis();
        double worstPercent = Math.abs(0.25-0.100);

        GeneticAlgorithm genetics = new GeneticAlgorithm();
        genetics.geneticAlgorithmDemo(geneticGUI,demo,start, metaImage, geneticGUI.getPopulationSize(), geneticGUI.getGenerations(), geneticGUI.getMutationPercent(), geneticGUI.getCrossoverPercent(),worstPercent, fitnessAlgorithm);

    }


}