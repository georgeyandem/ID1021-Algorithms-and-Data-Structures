/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Zip {
    Node[] data;
    int max;

    public class Node {
        String code;
        String name;
        Integer pop;

        public Node(String code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
         @Override
        public String toString() {
        return name; // Override the toString method to return the name when printing a Node.
        }
    }
    public Zip(String filename) {
    data = new Node[10000];
    try {
        InputStream is = getClass().getResourceAsStream("/resources/" + filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
        }
        max = i - 1;
    } catch (Exception e) {
        System.out.println("File " + filename + " not found");
    }
}


    public Node lookup(String zip) {
        for (int i = 0; i <= max; i++) {
            if (data[i].code.equals(zip)) {
                return data[i];
            }
        }
        return null; // Zip code not found
    }

    public Node binary(String zip) {
        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = data[mid].code.compareTo(zip);
            if (comparison == 0) {
                return data[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Zip code not found
    }

    public static void main(String[] args) {
        Zip zipData = new Zip("postnummer.csv");

        // Benchmarking
        String zip1 = "111 15";
        String zip2 = "984 99";

        // Linear search benchmark
        long startTime = System.nanoTime();
        Node result1 = zipData.lookup(zip1);
        Node result2 = zipData.lookup(zip2);
        long endTime = System.nanoTime();
        long linearSearchTime = endTime - startTime;
        
        // Binary search benchmark
        startTime = System.nanoTime();
        result1 = zipData.binary(zip1);
        result2 = zipData.binary(zip2);
        endTime = System.nanoTime();
        long binarySearchTime = endTime - startTime;

        System.out.println("Linear search result for " + zip1 + ": " + result1);
        System.out.println("Linear search result for " + zip2 + ": " + result2);
        System.out.println("Linear search time: " + linearSearchTime + " nanoseconds");

        System.out.println("Binary search result for " + zip1 + ": " + result1);
        System.out.println("Binary search result for " + zip2 + ": " + result2);
        System.out.println("Binary search time: " + binarySearchTime + " nanoseconds");
    }
}
*/