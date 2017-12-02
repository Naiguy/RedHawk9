import java.util.concurrent.Semaphore;

public class Sync 
{
	public static Semaphore sem = new Semaphore(1);
	
	
	public static void getLock() throws InterruptedException
	{
		if(sem.tryAcquire())
		{
			sem.acquire();
		}
	}
	
	public static void releaseLock()
	{
		sem.release();
	}
	
	public static int getAvailableSems()
	{
		return sem.availablePermits();
	}
}
