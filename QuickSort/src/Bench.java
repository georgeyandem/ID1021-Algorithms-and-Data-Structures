import java.util.Random;

public class Bench {

    public static void main(String[] args) {
        int[] array;
        QuickSortLinkedList linkedList;
        Random random = new Random();
        long startTime, endTime;
        int n = 1000; // Size of the dataset

        // Benchmark Quick Sort for Arrays
        System.out.println("Quick Sort for Arrays");
        for (int i = 1; i <= 10; i++) {
            int dataSize = n * i;
            array = generateRandomArray(dataSize, random);

            startTime = System.nanoTime();
            QuickSortArray.sort(array);
            endTime = System.nanoTime();

            double duration = (endTime - startTime);
            System.out.println("Data Size: " + dataSize + ", Time: " + duration + " nanoseconds");
        }

        // Benchmark Quick Sort for Linked Lists
        System.out.println("\nQuick Sort for Linked Lists");
        for (int i = 1; i <= 10; i++) {
            int dataSize = n * i;
            linkedList = generateRandomLinkedList(dataSize, random);

            startTime = System.nanoTime();
            linkedList.sort();
            endTime = System.nanoTime();

            double duration = (endTime - startTime);
            System.out.println("Data Size: " + dataSize + ", Time: " + duration + " nanoseconds");
        }
    }

    private static int[] generateRandomArray(int size, Random random) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    private static QuickSortLinkedList generateRandomLinkedList(int size, Random random) {
        QuickSortLinkedList linkedList = new QuickSortLinkedList();
        for (int i = 0; i < size; i++) {
            linkedList.append(random.nextInt());
        }
        return linkedList;
    }
}
