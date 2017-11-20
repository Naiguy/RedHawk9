import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.time.*;

import javax.swing.SwingUtilities;
import javax.swing.Timer;
import static java.util.concurrent.TimeUnit.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class ProcessScheduler extends Thread
{
	Queue<String> readyQueue = new LinkedList<String>();
	Queue<String> Queue = new LinkedList<String>();
	
	@SuppressWarnings("null")
	public void ScheduleProcesses(ArrayList<Process> Set)
	{
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
		boolean timeFlag = true;
		while (timeFlag) {
            Calendar a = Calendar.getInstance();

            
            String mili = Integer.toString(a.get(Calendar.MILLISECOND));
            String sec = Integer.toString(a.get(Calendar.SECOND));
            String min = Integer.toString(a.get(Calendar.MINUTE));
            String hour = Integer.toString(a.get(Calendar.HOUR_OF_DAY));
           
            String time = hour + ":" + min + ":" + sec + ":" + mili;

            System.out.println(time);
            
            for(Process p : Set)
    			{
    			
    			 System.out.println("Thread id "+this.getId());
    			 int baseCycle = p.getBaseCycle();
    			 long period = p.getPeriod();
    			 
    			 p.run();
    			 Set.get(3).run();
    			 //scheduler.scheduleWithFixedDelay(p, baseCycle, period, TimeUnit.SECONDS);
    			 System.out.println("P_ID: " + p.getPid());
    			}
            
            timeFlag = false;
            
//            scheduler.shutdown();
//	    		if(scheduler.isTerminated())
//	    		{
//	    			System.out.println("All tasks complete");
//	    		}
//    		
//            
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }		
	}
}
