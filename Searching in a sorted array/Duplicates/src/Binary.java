public class Binary 
{
    public static boolean search(int[] array, int key) 
    {
        int first = 0; // point to the first index in the array 
        int last = array.length - 1; // point to the last index in the array 

        while (first <= last)       
            {
                int mid = first + (last - first) / 2; 

                if (array[mid] == key)           
                    {
                        return true; // Found the target
                    } 
                    else if (array[mid] < key)  
                    {
                    first = mid + 1; // Search the right half 
                    } 
                    else                          
                    {
                    last = mid - 1; // Search the left half  
                    }
            }

        return false; // Target not found
    }
}
