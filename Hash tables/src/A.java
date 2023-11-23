/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class A {
    Node[] data;
    int max;

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

    public A(String filename) {
        data = new Node[10000]; // Initialize the array with a reasonable size
        try {
            InputStream is = getClass().getResourceAsStream("/resources/" + filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println("File " + filename + " not found");
        }
    }

    public void collisions(int mod) {
        int[] dataCounts = new int[mod]; // To count elements in each index
        int[] collisionCounts = new int[10]; // To track collision counts for different scenarios

        for (int i = 0; i <= max; i++) {
            Integer index = data[i].code % mod; // Apply the hash function
            dataCounts[index]++; // Count elements in each index
        }

        for (int count : dataCounts) {
            if (count > 1) {
                // Count collisions for different scenarios (e.g., two keys, three keys, etc.)
                collisionCounts[count - 1]++;
            }
        }

        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + collisionCounts[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        A zipData = new A("postnummer.csv");

        System.out.println("Mod\tCollisions");
        for (int mod : new int[]{10000, 20000, 12345, 13513, 13600, 14000}) {
            zipData.collisions(mod);
        }
    }
}*/
