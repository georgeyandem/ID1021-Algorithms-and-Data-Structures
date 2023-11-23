public class Doublets 
{
    public static int Linear (int[] array, int[] keys)
    {
        int doublets = 0;

        for (int i = 0; i < keys.length ; i++)
        {
            if (Linear.search(array, keys[i]))
            {
                doublets++;
            }
        } 
        return doublets;
    }  
    public static int binary(int[] array, int [] keys) 
    {
        int doublets = 0;

        for ( int i = 0; i < keys.length; i++)
        {
            if(Binary.search(array, keys[i]))
            {
                doublets++;
            }
        }
        return doublets;
    }
 
}
