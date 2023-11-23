public class AppendBenchmark {

    public static void main(String[] args) {
        int maxSize = 6400; // Change this to vary the size of the data structure

        long startTime, endTime;

        // Benchmark for linked list
        for (int size = 100; size <= maxSize; size *= 2) {
            LinkedList list = new LinkedList(size);

            startTime = System.nanoTime();
            // Perform some operation on the linked list (e.g., append)
            list.append(new LinkedList(size)); // Appending a new list for benchmark purposes
            endTime = System.nanoTime();

            long elapsedTime = endTime - startTime;
            System.out.println("Linked List - Size: " + size + ", Time taken: " + elapsedTime + " nanoseconds");
        }

        // Benchmark for fixed-size array
        for (int size = 100; size <= maxSize; size *= 2) {
            int[] arrayA = new int[size];
            int[] arrayB = new int[size];

            startTime = System.nanoTime();
            // Perform some operation on the array (e.g., append)
            int[] newArray = new int[size * 2]; // Allocate a new array
            System.arraycopy(arrayA, 0, newArray, 0, size); // Copy elements from arrayA to newArray
            System.arraycopy(arrayB, 0, newArray, size, size); // Copy elements from arrayB to newArray
            endTime = System.nanoTime();

            long elapsedTime = endTime - startTime;
            System.out.println("Fixed-Size Array - Size: " + size + ", Time taken: " + elapsedTime + " nanoseconds");
        }
    }
}
