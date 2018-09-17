package fitness.fitness_algorithms;

import fitness.fitness_factory.IFitness;

/**
 *
 * @author diesv
 */

public class Euclidean implements IFitness {

    @Override
    public float fitnessAlgorithm(int[][] p, int[][] q) {
        float sum = 0;
        int m = p.length;
        int n = p[0].length;


        for (int i=0; i< m; i++){
            for(int j = 0; j < n;j++ ){
                sum =sum + (float) Math.pow(p[i][j] - q[i][j], 2);
            }
        }
        return (float) Math.sqrt(sum);
    }
}


