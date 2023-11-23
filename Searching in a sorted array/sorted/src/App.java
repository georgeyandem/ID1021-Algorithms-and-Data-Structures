public class App 
{
    public static void linear(int[] array, int[] indx) 
    {
        for (int i = 0; i < indx.length ; i++) 
        {
            Linear.linearSearch(array, indx[i]);
        }
    }
        
    public static void binary(int[] array, int[] indx)
     {
        for (int i = 0; i < indx.length ; i++) 
        {
            Binary.binarySearch(array, indx[i]);
        }
    }

    public static void main(String[] args) throws Exception 
    {
        
        int[] sizes = {100,200,300,400,800,1600,3200};
       
        System.out.printf("# searching through an array of length n, time in ns\n");
	    System.out.printf("#%7s%8s%8s\n", "n", "linear", "binary");

	    for ( int n : sizes) 
        {
            int loop = 10000;
	    
	        int[] array = Array.sorted(n);
	        int[] indx = Key.keys(loop, n);

	        System.out.printf("%8d", n);

	        int k = 1000;
	    
	        double min = Double.POSITIVE_INFINITY;

	         for (int i = 0; i < k; i++) 
            {
                long t0 = System.nanoTime();
                linear(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
	        }
            System.out.printf("%8.0f", (min/loop));	    

	        min = Double.POSITIVE_INFINITY;
	    
	        for (int i = 0; i < k; i++) 
            {
		        long t0 = System.nanoTime();
		        binary(array, indx);
		        long t1 = System.nanoTime();
		        double t = (t1 - t0);
		        if (t < min)
		        min = t;
	        }

	        System.out.printf("%8.0f\n" , (min/loop));	    	    
	    }   
    }
}

// https://chat.openai.com/share/8e6e02d3-08fd-4fa5-a742-af9715dab34a


