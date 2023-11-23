import java.util.Random;

public class Key 
{
    public static int[] keys(int loop, int n) 
    {
	Random rnd = new Random();	
	int[] indx = new int[loop];
	for (int i = 0; i < loop ; i++) {
	    indx[i] = rnd.nextInt(n*5);
	}	
	return indx;
    }
}
