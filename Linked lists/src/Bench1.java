public class Bench1 
{
    public static void main(String[] args) {
        int bSize = 10000; // Fixed size of list (b)
        
        for (int aSize = 100; aSize <= 10000; aSize *= 2 ) {
            LinkedList listA = new LinkedList(aSize); // Create list (a) of size aSize
            LinkedList listB = new LinkedList(bSize); // Create list (b) of size bSize
            
            long startTime = System.nanoTime();
            listB.append(listA); // Perform the append operation
            long endTime = System.nanoTime();
            
            long duration = (endTime - startTime);
            System.out.println("List (a) size: " + aSize + ", Append Time: " + duration + " ns");
        }
    }
}
