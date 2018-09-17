package fitness.fitness_ut;

import fitness.fitness_algorithms.MSE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import fitness.fitness_factory.FitnessFactory;
import fitness.fitness_factory.IFitness;
import org.junit.jupiter.api.Test;

public class Test_MSE {

    @Test
    public static void testMSE(){
        MSE mse = new MSE();
        int array [][] = {{1, 2}, {3,4}};
        int array2 [][] = {{5, 6}, {7,8}};

        IFitness mseAlgorithm = FitnessFactory.getFitnessAlgorithm("MSE");
        assertEquals(16, mseAlgorithm.fitnessAlgorithm(array, array2), "MSE Test Failed");
    }
}
