public class Selection 
{
    public static void SelectionSort(int[] array) 
    {
        for(int i = 0; i < array.length-1; i++)
        {
            int candidate = i;
            for(int j = i; j < array.length; j++)
            {
                if (array[j] < array[candidate])
                {
                    candidate = j;
                }
            }
            if(candidate != i)
            {
                int pos = array[i];
                array[i] = array[candidate];
                array[candidate] = pos;
            }
        }
    }
}