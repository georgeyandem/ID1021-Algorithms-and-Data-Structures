public class Linear 
{
    public static boolean search(int[] array, int key) //search_unsorted
     {

        for (int index = 0; index < array.length ; index++) 
        {
            if (array[index] == key) 
            {
                return true;
            }
        }
        return false;
    }
}
