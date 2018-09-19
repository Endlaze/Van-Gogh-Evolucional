package fitness.fitness_algorithms;

import fitness.fitness_factory.IFitness;

public class JDJD  implements IFitness {

    @Override
    public float fitnessAlgorithm(int[][] p, int[][] q) {
        float sum = 0;
        int counter = 0;
        int partial = 0;
        int m = p.length;
        int n = p[0].length;


        for (int i=0; i< m; i++){
            for(int j = 0; j < n;j++ ){
                partial = Math.abs(p[i][j] - q[i][j]);
                sum += partial;
                if(partial == 0){
                    counter ++;
                }
            }
        }
        if (counter != 0) {
            return (float) sum - sum * (counter/m*n);
        }
        else {
            return sum;
        }
    }
}