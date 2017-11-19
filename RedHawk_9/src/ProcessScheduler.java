import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.ArrayList;
import static java.util.concurrent.TimeUnit.*;
public class ProcessScheduler extends Thread
{
	Queue<String> readyQueue = new LinkedList<String>();
	Queue<String> Queue = new LinkedList<String>();
	
	public void ScheduleProcesses(ArrayList<Process> Set)
	{
		ScheduledExecutorService scheduler;
		for(Process p : Set)
		{
			int baseCycle = p.getBaseCycle();
			int period = p.getPeriod();
			//scheduler.
			//timer.schedule(p, baseCycle, period);

		}
		//timer.
	}
	
	

}
