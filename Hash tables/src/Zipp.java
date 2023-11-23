import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Zipp {
    Node[] data;

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

    public Zipp(String filename, int capacity) {
        data = new Node[capacity]; // Initialize the array with the specified capacity
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
        int hash = code % data.length;
        while (data[hash] != null) {
            // Linear probing to find the next available slot
            hash = (hash + 1) % data.length;
        }
        data[hash] = new Node(code, name, pop);
    }

    public Node lookup(Integer zip) {
        int hash = zip % data.length;
        int originalHash = hash;
        while (data[hash] != null) {
            if (data[hash].code.equals(zip)) {
                return data[hash];
            }
            hash = (hash + 1) % data.length;
            if (hash == originalHash) {
                break; // If we've looped back to the original hash, the element is not found.
            }
        }
        return null; // Zip code not found
    }

    public static void main(String[] args) {
        int[] capacities = { 10000, 20000, 30000, 40000 }; // Experiment with different array sizes
        for (int capacity : capacities) {
            Zipp zipData = new Zipp("postnummer.csv", capacity);

            // Benchmarking
            Integer zip1 = 11115;
            Integer zip2 = 98499;

            long startTime = System.nanoTime();
            Node result1 = zipData.lookup(zip1);
            Node result2 = zipData.lookup(zip2);
            long endTime = System.nanoTime();
            long searchTime = endTime - startTime;

            System.out.println("Array size: " + capacity);
            System.out.println("Linear search result for " + zip1 + ": " + result1);
            System.out.println("Linear search result for " + zip2 + ": " + result2);
            System.out.println("Linear search time: " + searchTime + " nanoseconds\n");
        }
    }
}
