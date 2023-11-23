class ArrayHeap {
    private int[] heap;
    private int size;

    public ArrayHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void add(int value) {
        if (size == heap.length) {
            // Handle the case when the heap is full, e.g., by resizing the array.
            resizeHeap();
        }

        heap[size] = value;
        size++;

        int currentIndex = size;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap[currentIndex] > heap[parentIndex]) {
                // Swap the current value with its parent if it's greater
                int temp = heap[currentIndex];
                heap[currentIndex] = heap[parentIndex];
                heap[parentIndex] = temp;
                currentIndex = parentIndex;
            } else {
                break; // The element is in its correct position
            }
        }
    }

    public int remove() {
        if (size == 0) {
            // Handle the case when the heap is empty, e.g., by throwing an exception.
            throw new IllegalStateException("Heap is empty. Cannot remove.");
        }

        int removedValue = heap[0];
        size--;

        if (size > 0) {
            // Move the last element to the root
            heap[0] = heap[size];
    
            int currentIndex = 0;
            while (true) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;
                int largest = currentIndex;
    
                if (leftChildIndex < size && heap[leftChildIndex] > heap[largest]) {
                    largest = leftChildIndex;
                }
    
                if (rightChildIndex < size && heap[rightChildIndex] > heap[largest]) {
                    largest = rightChildIndex;
                }
    
                if (largest != currentIndex) {
                    // Swap the current value with the largest child
                    int temp = heap[currentIndex];
                    heap[currentIndex] = heap[largest];
                    heap[largest] = temp;
                    currentIndex = largest;
                } else {
                    break; // The element is in its correct position
                }
            }
        } else {
            // If the size becomes 0 after removing the root, set root to 0
            heap[0] = 0;
        }
    
        return removedValue;
    }

    public int push(int incr) {
        int depth = 0; // Variable to track the depth of the pushed element

        if (size > 0) {
            // Increment the root element by incr
            heap[0] += incr;
            int currentIndex = 0;

            while (true) {
                int leftChildIndex = 2 * currentIndex + 1;
                int rightChildIndex = 2 * currentIndex + 2;
                int largest = currentIndex;

                if (leftChildIndex < size && heap[leftChildIndex] > heap[largest]) {
                    largest = leftChildIndex;
                }

                if (rightChildIndex < size && heap[rightChildIndex] > heap[largest]) {
                    largest = rightChildIndex;
                }

                if (largest != currentIndex) {
                    // Swap the current value with the largest child
                    int temp = heap[currentIndex];
                    heap[currentIndex] = heap[largest];
                    heap[largest] = temp;
                    currentIndex = largest;
                    depth++; // Increment depth when swapping
                } else {
                    break; // The element is in its correct position
                }
            }
        }

        return depth; // Return the depth of the element
    }
    
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    private void resizeHeap() {
        int newCapacity = heap.length * 2;
        int[] newHeap = new int[newCapacity];
        System.arraycopy(heap, 0, newHeap, 0, size);
        heap = newHeap;
    }
    
public static void main(String[] args) {
        ArrayHeap heap = new ArrayHeap(10);

        // Test the add operation
        heap.add(5);
        heap.add(8);
        heap.add(7);
        heap.add(2);
        heap.add(12);
        heap.add(15);

        System.out.println("Heap after add operations:");
        heap.printHeap();

        // Test the push operation
        int pushDepth = heap.push(10);
        System.out.println("Pushed 10 to depth: " + pushDepth);

        System.out.println("Heap after push operation:");
        heap.printHeap();

        // Test the remove operation
        int removedValue = heap.remove();
        System.out.println("Removed value: " + removedValue);

        System.out.println("Heap after remove operation:");
        heap.printHeap();
    }
}
