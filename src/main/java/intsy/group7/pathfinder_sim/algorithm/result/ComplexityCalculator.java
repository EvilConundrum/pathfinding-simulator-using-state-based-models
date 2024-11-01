package intsy.group7.pathfinder_sim.algorithm.result;

public class ComplexityCalculator {
    private long nanosecondDuration;
    private long bytesUsed;

    private long startTime;
    private long startMemory;
    private final Runtime runtime = Runtime.getRuntime();

    // Start measurement (used before running the algorithm)
    public void start() {
        startTime = System.nanoTime();
        System.gc();
        startMemory = runtime.totalMemory() - runtime.freeMemory();
    }

    // Stop measurement (used after running the algorithm)
    public void stop() {
        // Measure amount of time in nanoseconds
        long endTime = System.nanoTime();
        nanosecondDuration = endTime - startTime;

        // Measure amount of memory used in bytes
        long endMemory = runtime.totalMemory() - runtime.freeMemory();
        bytesUsed = endMemory - startMemory;
    }

    public long getNanosecondDuration() {
        return nanosecondDuration;
    }

    public long getBytesUsed() {
        return bytesUsed;
    }

    // Optional method to print results
    public void printResults() {
        System.out.println("Time taken: " + nanosecondDuration + " nanoseconds");
        System.out.println("Memory used: " + bytesUsed + " bytes");
    }
}