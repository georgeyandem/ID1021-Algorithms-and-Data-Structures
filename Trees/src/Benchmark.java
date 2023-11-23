import java.util.Random;

public class Benchmark {
    public static void main(String[] args) {
        int[] sizes = {100, 200, 400, 800, 1600, 3200};
        Random random = new Random();

        for (int dataSize : sizes) {
            BinaryTree tree = new BinaryTree();
            long startI = System.nanoTime();

            // Generate and insert random data into the binary tree
            for (int i = 0; i < dataSize; i++) {
                int key = random.nextInt(dataSize); // Random key within the data size
                int value = random.nextInt(); // Random value
                tree.add(key, value);
            }
            Long endI = System.nanoTime();

            long insertTime = endI - startI;

            // Measure lookup time for a subset of keys
            long startL = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                int lookupKey = random.nextInt(dataSize);
                Integer result = tree.lookup(lookupKey);
            }
            long endL = System.nanoTime(); 
            long lookupTime = endL - startL;

            System.out.println("Data Size: " + dataSize);
            System.out.println("Insert Time: " + insertTime + " ns");
            System.out.println("Lookup Time: " + lookupTime + " ns");
            System.out.println("------------");
            
        }
    }
}
