package fitness.fitness_ut;

import static org.junit.jupiter.api.Assertions.assertEquals;


import fitness.fitness_factory.FitnessFactory;
import fitness.fitness_factory.IFitness;
import org.junit.jupiter.api.Test;

public class Test_Euclidean {

    @Test
    public static void testMSE(){

        int array [][] = {{1, 2}, {3,4}};
        int array2 [][] = {{5, 6}, {7,8}};

        IFitness euclidean = FitnessFactory.getFitnessAlgorithm("EUCLIDEAN");

        assertEquals(8, euclidean.fitnessAlgorithm(array, array2), "Euclidean Test Failed");
    }
}
