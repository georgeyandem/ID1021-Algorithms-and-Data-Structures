import java.util.Random;

public class Bench2 {

    public static void main(String[] args) {
        final int k = 1000;  // Number of cells to unlink and insert
        Random random = new Random();

        // Vary n from low to high values, e.g., powers of 10
        int[] nValues = {100, 200, 400, 800, 1600,3200};

        for (int n : nValues) {
            LinkedList singlyLinkedList = new LinkedList();
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            // Create an array of cells and keep references in the cell array
            LinkedList.Cell[] cellArray = new LinkedList.Cell[n];
            
            for (int i = 0; i < n; i++) {
                singlyLinkedList.add(i);
                cellArray[i] = singlyLinkedList.new Cell(i, null);
            }

            DoublyLinkedList.Cell[] doublyCellArray  = new DoublyLinkedList.Cell[n];
            for (int i = 0; i < n; i++) {
                doublyLinkedList.add(i);
                doublyCellArray[i] = doublyLinkedList.new Cell(i, null, null);
            }

            // Create an array of k random numbers between 0 and n-1
            int[] randomIndices = new int[k];
            for (int i = 0; i < k; i++) {
                randomIndices[i] = random.nextInt(n);
            }

            // Benchmark for singly linked list
            long startTimeSingly = System.nanoTime();
            for (int index : randomIndices) {
                LinkedList.Cell cellToUnlink = cellArray[index];
                singlyLinkedList.unlinkS(cellToUnlink);
                singlyLinkedList.add(cellToUnlink.head);
            }
            long endTimeSingly = System.nanoTime();
            long elapsedTimeSingly = endTimeSingly - startTimeSingly;

            // Benchmark for doubly linked list
            long startTimeDoubly = System.nanoTime();
            for (int index : randomIndices) {
                DoublyLinkedList.Cell cellToUnlink = doublyCellArray[index];
                doublyLinkedList.unlinkD(cellToUnlink);
                doublyLinkedList.insertAsFirst(cellToUnlink);
            }
            long endTimeDoubly = System.nanoTime();
            long elapsedTimeDoubly = endTimeDoubly - startTimeDoubly;

            // Present the results in a sensible form (e.g., milliseconds)
            double elapsedTimeSinglyMs = elapsedTimeSingly ; // Convert nanoseconds to milliseconds
            double elapsedTimeDoublyMs = elapsedTimeDoubly ;

            System.out.println("Benchmark for n = " + n);
            System.out.println("Singly Linked List Time: " + String.format("%.2f", elapsedTimeSinglyMs) + " ns");
            System.out.println("Doubly Linked List Time: " + String.format("%.2f", elapsedTimeDoublyMs) + " ns");
            System.out.println();
        }
    }
}
