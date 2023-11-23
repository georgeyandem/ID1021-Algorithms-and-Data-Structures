/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Zipoo {
    Bucket[] buckets;

    public class Node {
        Integer code;
        String name;
        Integer pop;

        public Node(Integer code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class Bucket {
        List<Node> elements = new ArrayList<>();
        
        public void add(Node node) {
            elements.add(node);
        }

        public Node find(Integer zip) {
            for (Node node : elements) {
                if (node.code.equals(zip)) {
                    return node;
                }
            }
            return null;
        }
    }

    public Zipoo(String filename) {
        buckets = new Bucket[10000]; // Initialize the array of buckets with a reasonable size
        try {
            InputStream is = getClass().getResourceAsStream("/resources/" + filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                addElement(code, row[1], Integer.valueOf(row[2]));
            }
        } catch (Exception e) {
            System.out.println("File " + filename + " not found");
        }
    }

    public void addElement(Integer code, String name, Integer pop) {
        int hash = code % buckets.length;
        if (hash < 0) {
            // Handle the case where the hash is out of bounds.
            return;
        }
        
        if (buckets[hash] == null) {
            buckets[hash] = new Bucket();
        }
        
        buckets[hash].add(new Node(code, name, pop));
    }

    public Node lookup(Integer zip) {
        int hash = zip % buckets.length;
        if (hash < 0 || hash >= buckets.length || buckets[hash] == null) {
            return null; // Zip code not found
        }
        
        return buckets[hash].find(zip);
    }

    public static void main(String[] args) {
        Zipoo zipData = new Zipoo("postnummer.csv");

        // Benchmarking
        Integer zip1 = 11115;
        Integer zip2 = 98499;

        // Linear search benchmark
        long startTime = System.nanoTime();
        Node result1 = zipData.lookup(zip1);
        Node result2 = zipData.lookup(zip2);
        long endTime = System.nanoTime();
        long linearSearchTime = endTime - startTime;
        
        System.out.println("Linear search result for " + zip1 + ": " + result1);
        System.out.println("Linear search result for " + zip2 + ": " + result2);
        System.out.println("Linear search time: " + linearSearchTime + " nanoseconds");
    }
}*/