import java.util.Random;

public class Array 
{
    
    public static int[] sorted(int n) // generating a sorted array (no duplicates)
    {
        Random rnd = new Random();	
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);
        
        for (int i = 0; i < n ; i++) 
        {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1 ;
        }	
        return array;
    }
    
}
