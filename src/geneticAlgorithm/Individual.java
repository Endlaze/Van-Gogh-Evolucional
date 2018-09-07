package geneticAlgorithm;

import java.util.Random;

public class Individual {
    public  int [][] genes;
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

}