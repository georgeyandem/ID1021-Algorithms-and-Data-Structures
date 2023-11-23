public class Bench2 
{
    public static void main(String[] args) {
        int aSize = 1000; // Fixed size of list (a)
        
        for (int bSize = 100; bSize <= 10000; bSize *= 2) {
            LinkedList listA = new LinkedList(aSize); // Create list (a) of size aSize
            LinkedList listB = new LinkedList(bSize); // Create list (b) of size bSize
            
            long startTime = System.nanoTime();
            listB.append(listA); // Perform the append operation
            long endTime = System.nanoTime();
            
            long duration = (endTime - startTime);
            System.out.println("List (b) size: " + bSize + ", Append Time: " + duration + " ns");
        }
    }
}
