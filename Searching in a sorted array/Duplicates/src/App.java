public class App 
{

    public static void main(String[] args) throws Exception 
    {
    int[] sizes = {100, 200, 300, 400, 800, 1600, 3200};
    
    System.out.printf("# Searching through an array of length n, time in ns\n");
    System.out.printf("#%7s%8s%8s%8s\n", "n", "linear", "binary", "optimize");


    for (int n : sizes) 
    {
        int loop = 10000; //10000

        int[] array = Key.keys(loop, n); // Generate random keys
        int[] indx = Key.keys(loop, n);  // Generate another set of random keys

        System.out.printf("%8d", n);

        int k = 1000; //1000

        double minLinear = Double.POSITIVE_INFINITY;
        double minBinary = Double.POSITIVE_INFINITY;
        double minOptimized = Double.POSITIVE_INFINITY;

        for (int i = 0; i < k; i++) 
        {
            long t0 = System.nanoTime();
                Doublets.Linear(array, indx); // Use Doublets.Linear for linear search
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < minLinear)
                    minLinear = t;

                t0 = System.nanoTime();
                Doublets.binary(array, indx); // Use Doublets.binary for binary search
                t1 = System.nanoTime();
                t = (t1 - t0);
                if (t < minBinary)
                    minBinary = t;

                t0 = System.nanoTime();
                Optimize.find(array, indx); // Use Optimaz.find for optimized search
                t1 = System.nanoTime();
                t = (t1 - t0);
                if (t < minOptimized)
                    minOptimized = t;
            }

            System.out.printf("%8.0f%8.0f%8.0f\n", (minLinear / loop), (minBinary / loop), (minOptimized / loop));
        }   
    }
}
	    
	      