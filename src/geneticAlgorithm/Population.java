package geneticAlgorithm;

import java.util.ArrayList;
import java.util.Random;

public class Population {

    private Individual [] individuals;


    public Population(int populationSize, int height, int width){
        initializePopulation(populationSize,height,width);
    }

    //Function to init population

    private void initializePopulation(int populationSize, int height, int width){
        this.individuals = new Individual[populationSize];
        for(int i=0; i<populationSize; i++){
            Individual individual =new Individual(height, width);
            this.individuals[i] = (individual);
        }
    }

    //Function to get individuals

    public Individual[] getIndividuals() {
        return individuals;
    }

    // Function for individuals crossover

    public void individualsCrossover(Individual individual1, Individual individual2, double percent){

        int [][] indi1Genes = individual1.getGenes();
        int [][] indi2Genes = individual2.getGenes();

        int numberOfRowsToCross = (int) ((percent/100)*indi1Genes.length);


        for (int i=0; i<numberOfRowsToCross;i++){
            int random = new Random().nextInt(indi1Genes.length);
            int [] temp = indi1Genes[random];
            indi1Genes[random] =indi2Genes[random];
            indi2Genes[random]=temp;
        }

        individual1.setGenes(indi1Genes);
        individual2.setGenes(indi2Genes);
    }
}
