package geneticAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class Individual {
    private int [][] genes;
    public double   fitness;

    public Individual(int height, int width) {
        generateIndividualGenes(height, width);
    }

    public void setFitness(double fitness){
        this.fitness = fitness;

    }


    public void generateIndividualGenes(int height, int width){
        this.genes = new int[height][width];
        for(int row=0;row<height;row++)
        {
            for (int col = 0; col < width; col++) {
                Random rand = new Random();
                this.genes[row][col] = rand.nextInt((255) + 0) ;

            }
        }
    }

    public void mutate(double percent){

        Random random = new Random();

        for (int row = 0; row < this.genes.length; row++) {
            for (int col = 0; col < this.genes[row].length; col++) {

                if (random.nextDouble() <=percent){
                    this.genes[row][col] = random.nextInt(255);
                }
            }}
    }




    public int[][] getGenes(){
        return this.genes;
    }
    public void setGenes(int [][] genes){
        this.genes=genes;
    }

}