import java.io.*;

public class ThreadHelloCount
{
	public static void main(String[] args)
	{
		HelloThread hello = new HelloThread();
		CountThread count = new CountThread();
		
		hello.start();
		count.start();
	}
}

class HelloThread extends Thread
{
	public void run()
	{
		for (int i=0; i<5; i++)
		{
			try
			{
				System.out.println("Merhaba");
				sleep((int)(Math.random()*1000));
			}
			catch (InterruptedException interruptEx)
			{
				System.out.println(interruptEx);
			}
		}
	}
}

class CountThread extends Thread
{
	public void run()
	{
		for (int i=0; i<5; i++)
		{
			try
			{
				System.out.println(i);
				sleep((int )(Math.random()*1000));
			}
			catch (InterruptedException interruptEx)
			{
				System.out.println(interruptEx);
			}
		}
	}
}