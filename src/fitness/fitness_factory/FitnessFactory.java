package fitness.fitness_factory;


import fitness.fitness_algorithms.Euclidean;
import fitness.fitness_algorithms.MSE;

public class FitnessFactory {

    public static IFitness getAdaptabilityAlgorithm(String algorithm){

        switch (algorithm){
            case "EUCLIDEAN":
                return new Euclidean();
            case "MSE":
                return new MSE();
            case "OUR_ALGORITHM":
                return null;
            default:

        }
        return null;
    }


}
