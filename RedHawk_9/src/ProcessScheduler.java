import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.ArrayList;
public class ProcessScheduler extends Thread
{
	Queue<String> readyQueue = new LinkedList<String>();
	Queue<String> Queue = new LinkedList<String>();
	
	public void ScheduleProcesses(ArrayList<Process> Set)
	{
		Timer timer = new Timer();
		for(Process p : Set)
		{
			p.
			timer.schedule(p, p., period);

		}
	}
	
	

}
