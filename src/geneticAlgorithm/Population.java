package geneticAlgorithm;

import java.util.ArrayList;

public class Population {


    ArrayList<Individual> individuals = new ArrayList<>();

    public Population(int populationSize){
        initializePopulation(populationSize);
    }

    private void initializePopulation(int populationSize){

        for(int i=0; i<populationSize; i++){
            //this.individuals.add(new Individual());
        }
    }
}
