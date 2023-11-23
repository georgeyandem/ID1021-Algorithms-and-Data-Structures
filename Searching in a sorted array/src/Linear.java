public class Linear
{
    public static boolean linearSearch(int[] array, int key) //search_unsorted
     {

        //long start = System.nanoTime();

        for (int index = 0; index < array.length ; index++) 
        {
            if (array[index] == key) 
            {
                return true;
            }
        }
        //long end = System.nanoTime();
        //System.out.println("linear search time: " + (end - start) + " nanoseconds");
        return false;
    }
            
}
