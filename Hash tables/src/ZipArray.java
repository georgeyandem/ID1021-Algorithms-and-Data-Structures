/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class ZipArray {
    Node[] data;

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

    public ZipArray(String filename) {
        data = new Node[100000]; // Increase the array size to accommodate the possible range of zip codes

        try {
            InputStream is = getClass().getResourceAsStream("/resources/" + filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[code] = new Node(row[1], Integer.valueOf(row[2]));
            }
        } catch (Exception e) {
            System.out.println("File " + filename + " not found");
        }
    }

    public Node lookup(String zip) {
        Integer code = Integer.valueOf(zip.replaceAll("\\s", ""));
        if (code >= 0 && code < data.length) {
            Node node = data[code];
            if (node != null) {
                return node;
            }
        }
        return null; // Zip code not found
    }

    public static void main(String[] args) {
        ZipArray zipData = new ZipArray("postnummer.csv");

        // Benchmarking
        String zip1 = "111 15";
        String zip2 = "984 99";

        // Direct indexing lookup benchmark
        long startTime = System.nanoTime();
        ZipArray.Node result1 = zipData.lookup(zip1);
        ZipArray.Node result2 = zipData.lookup(zip2);
        long endTime = System.nanoTime();
        long directLookupTime = endTime - startTime;

        System.out.println("Direct lookup result for " + zip1 + ": " + result1);
        System.out.println("Direct lookup result for " + zip2 + ": " + result2);
        System.out.println("Direct lookup time: " + directLookupTime + " nanoseconds");
    }
}*/
