import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import static java.util.concurrent.TimeUnit.*;
public class ProcessScheduler extends Thread
{
	Queue<String> readyQueue = new LinkedList<String>();
	Queue<String> Queue = new LinkedList<String>();
	
	@SuppressWarnings("null")
	public void ScheduleProcesses(ArrayList<Process> Set)
	{
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(Set.size());
		for(Process p : Set)
		{
			 int baseCycle = p.getBaseCycle();
			 long period = p.getPeriod();
			 scheduler.scheduleWithFixedDelay(p, baseCycle, period, TimeUnit.MICROSECONDS);
			 System.out.println("P_ID: " + p.getPid());
			 
			/* if(System.curre() > 50000)
			 {
				 System.out.println(System.currentTimeMillis());
				 System.out.println("System time greater than 5000");
				 //scheduler.shutdown();
			 }*/
			 
			// Executers.
		}
	}
	
	

}
