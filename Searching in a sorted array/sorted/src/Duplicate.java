public class Duplicate 
{
    public static boolean find(int [] array1, int[] array2)
    {

        int p1 = 0; //pointer for array1 
        int p2 = 0; //pointer for array2
        boolean found = false;

        while(p1 < array1.length && p2 < array2.length)
        {
            if (array1[p1] == array2[p2])
            {
                found =  true; // found the duplicate
                p1++;
                p2++;
                
            }
            else if (array1[p1] < array2[p2])
            {
                p1++; // move to the next element in array 1
            }
            else
            {
                p2++; //move to the next element in array 2
            }
        }
        long end = System.nanoTime();
        System.out.println("final Search time: " + (end - start) + " nanoseconds");
        return found; // no duplicates was found
    }
}
