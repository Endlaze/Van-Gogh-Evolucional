package geneticAlgorithm;

import java.util.Random;

public class Population {

   public Individual [] individuals;


    public Population(int populationSize, int height, int width){
        initializePopulation(populationSize,height,width);
    }

    //Function to initialize population

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

    public int[][] crossover(int [][] genes1, int [][] genes2, double percent){
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
