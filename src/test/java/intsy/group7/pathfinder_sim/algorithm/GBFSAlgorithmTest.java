package intsy.group7.pathfinder_sim.algorithm;

import intsy.group7.pathfinder_sim.algorithm.result.ComplexityCalculator;
import intsy.group7.pathfinder_sim.algorithm.result.Result;
import intsy.group7.pathfinder_sim.model.Node;

public class GBFSAlgorithmTest implements AlgorithmTest {

    private final int testRuns;

    public GBFSAlgorithmTest(int testRuns) {
        this.testRuns = testRuns;
    }

    /**
     * Runs the GBFS algorithm 5 times and returns the average time and memory usage.
     *
     * @param start The start node
     * @param goal  The goal node
     * @return The Result of the final run (you can adjust this to return other values if needed)
     */
    public Result testTimeComplexity(Node start, Node goal) {
        long totalNanosecondDuration = 0;
        Result finalResult = null;

        for (int i = 0; i < testRuns + 1; i++) {
            ComplexityCalculator calculator = new ComplexityCalculator(ComplexityCalculator.Mode.TIME);
            calculator.start();

            // Run GBFS algorithm
            finalResult = GBFSAlgorithm.GBFS(start, goal);

            calculator.stop();

            if (i != 0) {
                totalNanosecondDuration += calculator.getNanosecondDuration();
            }
        }

        // Calculate the average time used
        long averageNanosecondDuration = totalNanosecondDuration / testRuns;

        // Print the average results
        System.out.println("Average Time taken: " + averageNanosecondDuration + " nanoseconds");

        return finalResult;  // Return the last result or adjust as needed
    }
}
