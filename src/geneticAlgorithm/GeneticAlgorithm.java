package geneticAlgorithm;
import fitness.fitness_factory.FitnessFactory;
import fitness.fitness_factory.IFitness;
import gui.GUI;
import gui.ShowPictureGUI;
import utils.ImageParser;
import utils.Sort;
import utils.XYSeriesDemo;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class GeneticAlgorithm {
    ImageParser imageParser = new ImageParser();

    public void geneticAlgorithmDemo(GUI gui,XYSeriesDemo demo,long start, BufferedImage metaImage, int populationSize, int generations, double mutationPercent, double crossoverPercent,double worstPercent,  String algorithm){

        int [][] metaImageGenes = imageParser.imageToMatrix(metaImage);
        IFitness fitnessAlgorithm = FitnessFactory.getFitnessAlgorithm(algorithm);

        Population population = new Population(populationSize, metaImage.getHeight(), metaImage.getWidth());
        calculateGenerationFitness(population, fitnessAlgorithm, metaImageGenes);
        Arrays.sort(population.getIndividuals(), new Sort());

        Individual[] finalIndividuals =new Individual[10];
        int progressionIndividual = 0;
        int individualCounter =0;

       for(int generationsCount = 0; generationsCount <generations; generationsCount++){

           generationCrossover(population, 1,populationSize/2,crossoverPercent);
           geneticsMutation(population, (int) ((populationSize/2)*0.6),populationSize/2,mutationPercent);
           generateNewIndividuals(population, populationSize/2, (int) (populationSize*worstPercent));


           float elapsedTimeSec = (System.currentTimeMillis() - start)/1000F;
           gui.setFittestImageLabel(imageParser.matrixToImage(population.getIndividuals()[0].getGenes()));
           demo.series.add(generationsCount,population.getIndividuals()[0].fitness);

           calculateGenerationFitness(population, fitnessAlgorithm, metaImageGenes);
           Arrays.sort(population.getIndividuals(), new Sort());

           if(progressionIndividual == generationsCount){
               finalIndividuals[individualCounter]= population.getIndividuals()[0];
               progressionIndividual+= ((int) (generations*0.10));
               individualCounter++;
           }
       }
       finalIndividuals[9]= population.getIndividuals()[0];
       finalIndividuals = imageParser.revIndividuals(finalIndividuals);
       finalImage(finalIndividuals);
    }

    public void calculateGenerationFitness(Population population, IFitness fitness, int [][] metaImage){

        for (var individual: population.getIndividuals()) {
            individual.setFitness(fitness.fitnessAlgorithm(metaImage,individual.getGenes()));
        }
    }
    public void geneticsMutation(Population population, int startingGene, int endingGene, double percent){
        for (int i=startingGene; i<endingGene; i++){
            population.getIndividuals()[i].mutate(percent);
        }
    }

    public void generationCrossover(Population population, int firstIndividualPosition, int lastIndividualPosition, double percent ){
        for (int i=firstIndividualPosition; i<lastIndividualPosition; i+=2){
            population.getIndividuals()[i].setGenes(population.crossover(population.getIndividuals()[i].getGenes(),population.getIndividuals()[i+1].getGenes(),percent));
        }
    }

    public void generateNewIndividuals(Population population,int firstIndividualPosition, int lastIndividualPosition){
        for (int i= firstIndividualPosition; i<lastIndividualPosition; i++){
            population.getIndividuals()[i].generateIndividualGenes(population.getIndividuals()[0].getGenes().length,population.getIndividuals()[0].getGenes()[0].length);
        }
    }

    public void finalImage(Individual [] finalIndividuals){

        int [][] finalImageMatrix = new int[finalIndividuals[0].getGenes().length][finalIndividuals[0].getGenes()[0].length*finalIndividuals.length];


        for(int i=0; i<finalImageMatrix.length; i++){
            int finalMatrixCount = 0;
            for (var individual: finalIndividuals) {
            for(int j=0; j<(finalIndividuals[0].getGenes()[0].length); j++){
                finalImageMatrix[i][finalMatrixCount] = individual.getGenes()[i][j];
                finalMatrixCount++;
            }}
        }
        ImageParser parser = new ImageParser();
        ShowPictureGUI showPic = new ShowPictureGUI();
        BufferedImage tenImage = parser.matrixToImage(finalImageMatrix);
        showPic.showPicture(tenImage);

        }
}
