public class StaticCalculator 
{
    Item[] expr;
    int ip;
    Stack stack;

    public StaticCalculator(Item[] expr) 
    {
    this.expr = expr;
    this.ip = 0;
    this.stack = new StaticStack(1024);
    }

public int run() throws Exception 
    {
        while ( ip < expr.length ) 
        {
            step();
        }
        return stack.pop();
    }
public void step() throws Exception 
    {
        Item nxt = expr[ip++];
        switch(nxt.getType()) 
        {
            case ADD: 
            {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB: 
            {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }
            case MUL:
            {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y );
                break;
            }
            case DIV: 
            {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                break;
            }
            case VALUE: 
            {
                stack.push(nxt.getValue());
                //System.out.println(nxt.value());
                break;
            }
        }

    }
}

