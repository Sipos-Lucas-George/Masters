package utils;

public class TimerUtil {

    /**
     * Measures the execution time of a given task.
     *
     * @param task the task to execute and measure.
     * @return the elapsed time in milliseconds.
     */
    public static long measure(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000; // Convert nanoseconds to milliseconds
    }
}
