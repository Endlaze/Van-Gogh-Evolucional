package fitness.fitness_algorithms;

import fitness.fitness_factory.IFitness;

public class MSE implements IFitness {

    @Override
    public float fitnessAlgorithm(int [][] p, int [][] q) {
        float result =0;
        int m = p.length;
        int n = p[0].length;

        for (int i=0; i< m; i++){
            for(int j = 0; j < n;j++ ){
                result =result + (float) Math.pow(p[i][j] - q[i][j], 2);
            }
        }
        return (float) ((1.0/(m*n))*result);
    }
}
