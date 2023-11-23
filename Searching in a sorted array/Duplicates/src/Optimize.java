public class Optimize 
{
    public static long find(int[] array1, int[] array2) 
    {
        long start = System.nanoTime();
        int p1 = 0; // Pointer for array1 
        int p2 = 0; // Pointer for array2

        while (p1 < array1.length && p2 < array2.length) 
        {
            if (array1[p1] == array2[p2]) 
            {
                p1++;
                p2++;
            } 
            else if (array1[p1] < array2[p2]) 
            {
                p1++; // Move to the next element in array 1
            } 
            else 
            {
                p2++; // Move to the next element in array 2
            }
        }
        long end = System.nanoTime();
        return end - start; // Return the execution time in nanoseconds
    }
}
