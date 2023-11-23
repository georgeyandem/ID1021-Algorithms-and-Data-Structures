public class Test 
{
        public static void main(String[] args) {
            int bSize = 10000; // Fixed size of list (b)
    
            for (int aSize = 100; aSize <= 10000; aSize *= 2) {
                // Benchmark linked list construction
                long listConstructionStartTime = System.nanoTime();
                LinkedList listA = new LinkedList(aSize); // Create list (a) of size aSize
                long listConstructionEndTime = System.nanoTime();
                long listConstructionDuration = (listConstructionEndTime - listConstructionStartTime);
    
                // Benchmark array allocation
                long arrayAllocationStartTime = System.nanoTime();
                int[] arrayA = new int[aSize]; // Create an array of size aSize
                long arrayAllocationEndTime = System.nanoTime();
                long arrayAllocationDuration = (arrayAllocationEndTime - arrayAllocationStartTime);
    
                System.out.println("List (a) size: " + aSize + ", List Construction Time: " + listConstructionDuration + " ns, Array Allocation Time: " + arrayAllocationDuration + " ns");
            }
        }
    }
    

    

