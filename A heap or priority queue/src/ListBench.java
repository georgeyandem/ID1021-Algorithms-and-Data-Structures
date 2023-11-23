import java.util.Random;

public class ListBench {
    public static void main(String[] args) {
        LinkedHeap binaryHeap = new LinkedHeap();
        Random random = new Random();
        int numElements = 1023;
        int minRandomValue = 0;
        int maxRandomValue = 10000;

        // Add 1023 elements with random values to the heap
        for (int i = 0; i < numElements; i++) {
            int randomValue = random.nextInt(maxRandomValue - minRandomValue + 1) + minRandomValue;
            binaryHeap.add(randomValue);
        }

        // Perform a sequence of dequeue and add operations and collect time statistics
        int numOperations = 100; // You can adjust this number as needed
        int minIncrement = 10;
        int maxIncrement = 100;
        
        long startTime = System.nanoTime();

        for (int i = 0; i < numOperations; i++) {
            int dequeuedValue = binaryHeap.remove();
            int increment = random.nextInt(maxIncrement - minIncrement + 1) + minIncrement;
            binaryHeap.add(dequeuedValue + increment);
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // Calculate and display execution time
        double executionTimeInNonoSeconds = elapsedTime;
        System.out.println("Number of operations: " + numOperations);
        System.out.println("Total execution time (nanoseconds): " + executionTimeInNonoSeconds);
        
        // Perform the same sequence of push operations and collect time statistics
        startTime = System.nanoTime();

        for (int i = 0; i < numOperations; i++) {
            int increment = random.nextInt(maxIncrement - minIncrement + 1) + minIncrement;
            binaryHeap.push(increment);
        }

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        // Calculate and display execution time for push operations
        double pushExecutionTimeInNanoSeconds = elapsedTime;
        System.out.println("Total execution time for push operations (nanoseconds): " + pushExecutionTimeInNanoSeconds);
    }
}
