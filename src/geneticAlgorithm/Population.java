package geneticAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Population {


    private ArrayList<Individual> individuals = new ArrayList<>();

    public Population(int populationSize, int height, int width){
        initializePopulation(populationSize,height,width);
    }

    private void initializePopulation(int populationSize, int height, int width){

        for(int i=0; i<populationSize; i++){
            Individual individual =new Individual(height, width);
            this.individuals.add(individual);
        }
    }

    public ArrayList<Individual> getIndividuals() {
        return individuals;
    }

    public ArrayList<Individual> individualCrossover(int [][] individual1, int [][]individual2, double percent){
        ArrayList<Individual> crossedIndividuals = new ArrayList<>();
        int numberOfRowsToCross = (int) ((percent/100)*individual1.length);


        for (int i=0; i<numberOfRowsToCross;i++){
            int random = new Random().nextInt(individual1.length);
            int [] temp = individual1[random];
            individual1[random] =individual2[random];
            individual2[random]=temp;
        }

        crossedIndividuals.add(new Individual(individual1.length, individual1[0].length));
        crossedIndividuals.add(new Individual(individual1.length, individual1[0].length));
        crossedIndividuals.get(0).setGenes(individual1);
        crossedIndividuals.get(1).setGenes(individual2);

        return crossedIndividuals;
    }
}
