
import java.util.*;



class Resource
{
	private int numResources;
	private final int MAX = 5;
	Stack<Integer> stack	= new Stack<Integer>();
		
	public Resource(int startLevel)
	{
		numResources = startLevel;
	}
	
	public int getLevel()
	{
		return numResources;
	}
	
	public synchronized void addOne()
	{
		try
		{
			while (numResources >= MAX)	wait();
			
			int	uretilen = (int)(Math.random() * 100);
			stack.push(uretilen);	
				
			numResources++;			
			System.out.println("Pushed Item = " + uretilen);			
			
			//'Wake up' any waiting consumer...
			notifyAll();
		}
		catch (InterruptedException interruptEx)
		{
			System.out.println(interruptEx);
		}
	}
	
	public synchronized int takeOne()
	{
		int tuketilen=0;
		try
		{			
			while (numResources == 0) wait();
			
			tuketilen=(int)stack.pop();
			
			numResources--;
			System.out.println("Poped Item = " + tuketilen);
			
			//'Wake up' waiting producer...
			notify();
		}
		catch (InterruptedException interruptEx)
		{
			System.out.println(interruptEx);
		}
		return tuketilen;
	}
}