public class Insertion 
{
    public static void InsertionSort(int [] array)
    {
        for(int i = 1; i <array.length; i++) 
        {
            for(int j = i; j > 0 && array[j] < array[j - 1]; j--)
            {
                swap(array, j, j - 1); // Swap arr[j] and arr[j - 1] 
            }
        }
    }
    public static void swap(int[] array, int i, int j) 
    {
        // Swaps two elements in the array
        int pos = array[i];
        array[i] = array[j];
        array[j] = pos;
    }
}
