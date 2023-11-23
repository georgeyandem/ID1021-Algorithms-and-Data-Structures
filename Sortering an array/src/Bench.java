import java.util.Random;

public class Bench 
{
    public static void main(String[] args) 
    {
        Random random = new Random(); 
        int[] sizes = {100,200,400,800,1600,3200,6400,12800,25600}; 
        
        for(int n : sizes)
        {
            int[] array = new int[n];
           
            for(int i = 0; i < n; i++) // Fill the array with random integers
            {
                array[i] = random.nextInt(10000); // Adjust the range as needed
            }

            long startS = System.nanoTime();
            Selection.SelectionSort(array); 
            long endS = System.nanoTime();
            long durationS = endS - startS;

            long startI = System.nanoTime();
            for(int j = 0; j < 10; j++)     //loop = 10
            {
                int[] clone = array.clone();
                Insertion.InsertionSort(clone);
            }
            long endI = System.nanoTime();
            long durationI = endI - startI;
            
            long startM = System.nanoTime();
            Merge.sort(array); 
            long endM = System.nanoTime();
            long durationM = endM - startM;

            long startO = System.nanoTime();
            MergeOptimized.sort(array); 
            long endO = System.nanoTime();
            long durationO = endO - startO;


            System.out.println("Array size: " + n);
            System.out.println("Selection Sort Time (ns): " + durationS);
            System.out.println("Insertion Sort Time (ns): " + durationI);
            System.out.println("Merge Sort Time (ns): " + durationM);
            System.out.println("Merge Optimized Time (ns): " + durationO);
            System.out.println("---------------------------");
        }
    }
}

