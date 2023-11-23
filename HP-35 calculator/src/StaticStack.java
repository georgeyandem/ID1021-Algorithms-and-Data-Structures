public class StaticStack extends Stack
{
    int[] stack; //array
    int top;
    int size;

    public StaticStack(int size) 
    {
        stack = new int[size];
        top = 0;
        this.size = size;
    }
    public void push(int value)
    {
        if (top <= size-1) //(top <= size)
        {
            stack[top] = value;
            top++;
            //System.out.println(stack[--top]);
        }
        else
        {
            System.out.println ("overflow");
        }
    }
    public int pop() throws Exception
    {
        if (top >= 0)
        {
            top--;
            //int value = stack[top];
            //top--; 
            return stack[top];
        }
        else
        { 
            throw new Exception ("empty stack");
        }
        
    }
}
