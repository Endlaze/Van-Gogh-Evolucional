import fitness.fitness_factory.FitnessFactory;
import fitness.fitness_factory.IFitness;
import fitness.fitness_ut.Test_Euclidean;
import fitness.fitness_ut.Test_MSE;
import fitness.fitness_utils.GrayScaleFilter;
import geneticAlgorithm.Population;
import gui.ShowPictureGUI;
import org.jfree.ui.RefineryUtilities;
import utils.FileManager;
import utils.ImageParser;
import utils.Sort;
import utils.XYSeriesDemo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {
    static int [][] originalMatrix;



    public static void main(String[] args) throws IOException {


        //Tests
        Test_MSE.testMSE();
        Test_Euclidean.testMSE();
        testComponents();

    }
    public static   void  testComponents() throws IOException{
        FileManager toLoad = new FileManager();
        BufferedImage image = null;

        image = toLoad.ReadImage("mona.jpg");

        GrayScaleFilter filter = new GrayScaleFilter();
        filter.applyGrayScaleFilter(image);
        ShowPictureGUI gui = new ShowPictureGUI();
        gui.showPicture(image);
        ImageParser parser = new ImageParser();
        originalMatrix = parser.imageToMatrix(image);
        String algorithm = "MSE";
        IFitness mseAlgorithm = FitnessFactory.getAdaptabilityAlgorithm(algorithm);
        Population population = new Population(100,100,100);
        final XYSeriesDemo demo = new XYSeriesDemo(algorithm);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        long start = System.currentTimeMillis();







        while (true){


            for (var individual: population.getIndividuals()) {
                individual.fitness = mseAlgorithm.adaptabilityAlgorithm(originalMatrix,individual.getGenes());
            }

            Arrays.sort(population.getIndividuals(), new Sort());


            for (int i=1; i<50; i+=2){
               population.getIndividuals()[i].setGenes(cross(population.getIndividuals()[i].getGenes(),population.getIndividuals()[i+1].getGenes(),0.60));
            }


            for (int i=50; i<100; i++){

                population.getIndividuals()[i].mutate(0.005);
            }
            for (int i=40; i<50; i++){

                population.getIndividuals()[i].mutate(0.0005);
            }
            for (int i = 50; i < 99; i++){
                population.getIndividuals()[i].mutate(0.05);
            }
            for (int i = 80; i < 99; i++){
                population.getIndividuals()[i].setGenes(mutate( population.getIndividuals()[i].getGenes(),1));
            }
           // population.getIndividuals()[49].setGenes(cross(population.getIndividuals()[0].getGenes(),population.getIndividuals()[49].getGenes(),0.60));
            long elapsedTimeMillis = System.currentTimeMillis() - start;
            float elapsedTimeSec = elapsedTimeMillis/1000F;

            demo.series.add(elapsedTimeSec,population.getIndividuals()[0].fitness);
            gui.updatePicture(parser.matrixToImage(population.getIndividuals()[0].getGenes()));

        }


    }
    public static int [][] mutate(int [][] subject,double percent) {

        for (int row = 0; row < 100; row++) {
            for (int col = 0; col < 100; col++) {
                Random rand = new Random();
                if (rand.nextDouble() <= percent) {

                    int gene = -1*(originalMatrix[row][col]-subject[row][col]) ;

                    subject[row][col] = subject[row][col] +new Random(gene).nextInt() ;
                }
            }
        }
        return subject;
    }
    public static int [][] cross(int [][] genes1, int [][] genes2, double percent){
        Random random = new Random();

        int [] temp;
        for (int i = 0; i < genes1.length; i++){
            if (random.nextDouble() <= percent){
                temp = genes1[i];
                genes1[i] = genes2[i];
                genes2[i]= temp;
            }
            if (random.nextDouble()<=percent){
                int rand = new Random().nextInt(genes1.length);
                int temp2;
                temp2 = genes1[i][rand];
                genes1[i][rand] = genes2[i][rand];
                genes2[i][rand]= temp2;
            }
        }
        return genes1;
    }


}
