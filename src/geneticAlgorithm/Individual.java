package geneticAlgorithm;

import java.util.Random;

public class Individual {
    private int [][] genes;
    public float   fitness;

    public Individual(int height, int width) {
        fillArray(height, width);
    }

    private void fillArray(int height, int width){
        genes = new int[height][width];
        for(int row=0;row<height;row++)
        {
            for (int col = 0; col < width; col++) {
                Random rand = new Random();
                genes[row][col] = rand.nextInt((255) + 1) ;
            }
        }
    }
    public void mutate(double percent) {
        for (int row = 0; row < genes.length; row++) {
            for (int col = 0; col < genes[row].length; col++) {
                Random rand = new Random();
                if (rand.nextDouble() <= percent) {
                    rand = new Random();
                    genes[row][col] = rand.nextInt((255) + 1) ;
                }
            }
        }
    }

    public int[][] getGenes(){
        return this.genes;
    }
    public void setGenes(int [][] genes){
        this.genes=genes;
    }

}