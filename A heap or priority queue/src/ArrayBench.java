import java.util.Random;

public class ArrayBench {
    public static void main(String[] args) {
        int numElements = 1023;
        int maxValue = 10000;
        int minIncrement = 10;
        int maxIncrement = 100;

        ArrayHeap heap = new ArrayHeap(numElements * 2); // Increase capacity to accommodate 1023 elements

        Random random = new Random();

        // Add 1023 elements with random values to the heap
        for (int i = 0; i < numElements; i++) {
            int randomValue = random.nextInt(maxValue + 1);
            heap.add(randomValue);
        }

        // Perform a sequence of dequeue and add operations and collect time statistics
        int numOperations = 100; // You can adjust this number as needed

        long startTime = System.nanoTime();

        for (int i = 0; i < numOperations; i++) {
            int dequeuedValue = heap.remove();
            int increment = random.nextInt(maxIncrement - minIncrement + 1) + minIncrement;
            heap.add(dequeuedValue + increment);
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // Calculate and display execution time
        double executionTimeInSeconds = elapsedTime;
        System.out.println("Number of operations: " + numOperations);
        System.out.println("Total execution time (seconds): " + executionTimeInSeconds);

        // Perform the same sequence of push operations and collect time statistics
        startTime = System.nanoTime();

        for (int i = 0; i < numOperations; i++) {
            int increment = random.nextInt(maxIncrement - minIncrement + 1) + minIncrement;
            heap.push(increment);
        }

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        // Calculate and display execution time for push operations
        double pushExecutionTimeInSeconds = elapsedTime;
        System.out.println("Total execution time for push operations (seconds): " + pushExecutionTimeInSeconds);
    }
}
