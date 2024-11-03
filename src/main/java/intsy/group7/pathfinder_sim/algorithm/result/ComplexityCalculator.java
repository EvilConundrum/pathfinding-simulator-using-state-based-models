package intsy.group7.pathfinder_sim.algorithm.result;

public class ComplexityCalculator {
    private long nanosecondDuration;
    private long bytesUsed;

    private long startTime;
    private long startMemory;
    private final Runtime runtime = Runtime.getRuntime();

    private final Mode mode;

    public enum Mode {
        TIME,
        SPACE
    }

    public ComplexityCalculator(Mode mode) {
        this.mode = mode; // Set mode through constructor
    }

    // Start measurement (used before running the algorithm)
    public void start() {
        if (mode == null) {
            throw new IllegalStateException("Error: mode is null");
        }

        switch (mode) {
            case TIME:
                startTime = System.nanoTime();
                break;
            case SPACE:
                System.gc();
                startMemory = runtime.totalMemory() - runtime.freeMemory();
                break;
        }
    }

    // Stop measurement (used after running the algorithm)
    public void stop() {
        if (mode == null) {
            throw new IllegalStateException("Error: mode is null");
        }

        switch (mode) {
            case TIME:
                // Measure amount of time in nanoseconds
                long endTime = System.nanoTime();
                nanosecondDuration = endTime - startTime;
                break;
            case SPACE:
                // Measure amount of memory used in bytes
                long endMemory = runtime.totalMemory() - runtime.freeMemory();
                bytesUsed = endMemory - startMemory;
                break;
        }
    }

    public long getNanosecondDuration() {
        return nanosecondDuration;
    }

    public long getBytesUsed() {
        return bytesUsed;
    }

    // Reset measurements for a new calculation
    public void reset() {
        nanosecondDuration = 0;
        bytesUsed = 0;
        startTime = 0;
        startMemory = 0;
    }
}
