/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Key {
    Node[] data;
    int max;

    public class Node {
        String name;
        Integer pop;

        public Node(String name, Integer pop) {
            this.name = name;
            this.pop = pop;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public Key(String filename) {
        data = new Node[100000]; // Increase the size to accommodate zip codes up to 99999
        try {
            InputStream is = getClass().getResourceAsStream("/resources/" + filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[code] = new Node(row[1], Integer.valueOf(row[2]));
                if (code > max) {
                    max = code; // Update the max value
                }
            }
        } catch (Exception e) {
            System.out.println("File " + filename + " not found");
        }
    }

    public Node lookup(Integer zip) {
        if (zip >= 0 && zip <= max) {
            return data[zip];
        }
        return null; // Zip code not found
    }
    public Node binary(Integer zip) {
        int left = 0;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] != null && mid == zip) {
                return data[mid];
            } else if (mid < zip) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Zip code not found
    }
    public int hash(Integer zip, int mod) {
        return zip % mod;
    }

    public void experimentWithCollisions(int[] modValues) {
        for (int mod : modValues) {
            int[] buckets = new int[mod];
            int[] collisionCount = new int[10];

            for (int i = 0; i <= max; i++) {
                Integer zip = i;
                int bucket = hash(zip, mod);
                collisionCount[buckets[bucket]]++;
                buckets[bucket]++;
            }

            System.out.print("Modulo " + mod + ":\t");
            for (int i = 0; i < 10; i++) {
                System.out.print(collisionCount[i] + "\t");
            }
            System.out.println();
        }
    }

   public static void main(String[] args) {
    Key zipData = new Key("postnummer.csv");

    int[] modValuesToTest = {10000, 20000, 12345, 13513, 13600, 14000};

    zipData.experimentWithCollisions(modValuesToTest);

    // Benchmarking
    Integer zip1 = 11115;
    Integer zip2 = 98499;

    // Linear search benchmark
    long startTime = System.nanoTime();
    Key.Node result1 = zipData.lookup(zip1);
    Key.Node result2 = zipData.lookup(zip2);
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