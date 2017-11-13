//import 
import java.util.concurrent.*;;
public class HelloWorld extends Thread
{
	//can semaphores be assigned to any objects
	//create a process object
	//assign it a semaphore

	static Semaphore semaphore = new Semaphore(2);

	static class MyATMThread extends Thread 
	{
		String name = "";

		MyATMThread(String name)
		{
			this.name = name;
		}
	
		public void run() 
		{
			
		      System.out.println("Running Thread Name: "+ this.currentThread().getName());
		      System.out.println("Running Thread Priority: "+ this.currentThread().getPriority());
			try
			{
				System.out.println(name + " : acquiring lock...");
				System.out.println(name + " : available Semaphore permits now: " + semaphore.availablePermits());

				semaphore.acquire();
				
				System.out.println(name + " : got the permit!");
				
				try 
				{
					for (int i = 1; i <= 5; i++)
					{
						System.out.println(name + " : is performing operation " + i+ ", available Semaphore permits : " + semaphore.availablePermits());
						// sleep 1 second
						Thread.sleep(1000);
					}
					
					for (int i = 6; i <= 10; i++)
					{
						System.out.println(name + " : is performing operation " + i
								+ ", available Semaphore permits : "
								+ semaphore.availablePermits());
						// sleep 1 second
						Thread.sleep(5000);
					}

				} 
				finally
				{
					// calling release() after a successful acquire()
					System.out.println(name + " : releasing lock...");
					semaphore.release();
					System.out.println(name + " : available Semaphore permits now: "
								+ semaphore.availablePermits());
				}
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
	

	public static void main(String[] args) throws InterruptedException
	{
		System.out.println("Total available Semaphore permits : " + semaphore.availablePermits());
		//Process p1 = new Process();
		
		/*
		MultiThread t1 = new MultiThread();
		t1.setPriority(MIN_PRIORITY);
		t1.setName("t1");
		MultiThread t2 = new MultiThread();
		t2.setName("T2");
		t2.setPriority(MAX_PRIORITY);
		MultiThread t3 = new MultiThread();
		t3.setName("T3");
		t1.start();
		t2.start();
		t3.start();
		*/
		
		MyATMThread t4 = new MyATMThread("D");
		t4.start();

		MyATMThread t5 = new MyATMThread("E");
		t5.start();


		HelloWorld hw = new HelloWorld();
		hw.start();
	
	}
	
	
	public void run()
	{
		try {
			System.out.println("Goodbye Get a permit " + semaphore.availablePermits());
			semaphore.acquire();
			System.out.print("And goodbye to a permit " + semaphore.availablePermits());
			try
			{
				for(int i=0;i<=3;i++)
				{
					System.out.println("Enter Critical section");
				}
			}
			finally
			{
				System.out.println("Goodbye" + " : releasing lock...");
				semaphore.release();
				System.out.print("hello  permit " + semaphore.availablePermits());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


/*
   class MultiThread extends Thread
   {
    public void run(){
        System.out.println("Running Thread Name: "+ this.currentThread().getName());
        System.out.println("Running Thread Priority: "+ this.currentThread().getPriority());
    }
}
*/
