import java.util.Random;

public class Bench {

    public static void main(String[] args) {
        final int n = 10000; // Initial size of the list
        final int k = 1000;  // Number of cells to unlink and insert

        Random random = new Random();
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

        System.out.println("Singly Linked List Benchmark:");
        System.out.println("Time: " + elapsedTimeSingly + " nanoseconds");

        System.out.println("\nDoubly Linked List Benchmark:");
        System.out.println("Time: " + elapsedTimeDoubly + " nanoseconds");
    }
}
