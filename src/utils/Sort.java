package utils;

import geneticAlgorithm.Individual;

import java.util.Comparator;

public class Sort implements Comparator<Individual> {

    @Override
    public int compare(Individual individual1, Individual individual2) {
        if (individual1.fitness < individual2.fitness) return -1;
        if (individual1.fitness> individual2.fitness) return 1;
        return 0;
    }
}
