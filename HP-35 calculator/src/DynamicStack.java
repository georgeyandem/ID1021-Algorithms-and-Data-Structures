public class DynamicStack extends Stack 
{
    int[] stack; //array
    int top;
    int capacity;

    public DynamicStack(int capacity) 
    {
        stack = new int[capacity];
        top = 0;
        this.capacity = capacity;
    }
    public void push(int value)
    {
        if (top == capacity)
        {
            int[] copy = new int [capacity*2];
            for (int i = 0; i < stack.length; i++)
            {
                copy [i] = stack[i];
            }
            stack = copy; 
            capacity = capacity*2;
        }
        stack[top] = value;
        top++;
    }
    public int pop() throws Exception
    {
        if (top >= 0) 
        {
            top--; //  work 
            //int value = stack[top];
            //top--; //was 
            return stack[top]; //value;
        }
        else
        { 
            throw new Exception ("empty stack");
        }
    }

}
