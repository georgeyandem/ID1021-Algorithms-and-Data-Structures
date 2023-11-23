public class main 
{
    public static void main(String[] args) throws Exception 
    {
        // 10 + 1 * 5
        // 10 1 5 * + in reversed Polish notation
       Item[] expr = {  new Item (ItemType.VALUE,10),
                        new Item (ItemType.VALUE,2),
                        //new Item (ItemType.MUL,0),
                        //new Item (ItemType.DIV,0),
                        new Item (ItemType.ADD,0),
                        //new Item (ItemType.SUB,0),
                     };
 
        try
        {
            StaticCalculator Scalc = new StaticCalculator(expr); 
            System.out.println(" StaticCalculator Result = " + Scalc.run());
            DynamicCalculator Dcalc = new DynamicCalculator(expr);
            System.out.println("DynamicCalculator Result = " + Dcalc.run());
        } 
        catch(Exception e)
        {
            System.out.println("No value");
        }

        long staticTime = BenchMark(100, 1000, new StaticStack(1024));
        System.out.println("static time = " + staticTime);

        long dynamicTime = BenchMark(100, 1000, new DynamicStack(4));
        System.out.println("dynamic time = " + dynamicTime); 
    }

    public static long BenchMark(int loop, int ops, Stack stack) throws Exception
    {
        long start = System.nanoTime();
        for (int i = 0; i < loop; i++)
        { 
            for (int k = 0; k < ops; k++)
            {
                stack.push(k);
            }
            for (int k = 0; k < ops; k++)
            {
                stack.pop();
            }
        }
        long end = System.nanoTime();
        return ((end - start)/1000/loop);
        //return(end - start);
    }   
} 
