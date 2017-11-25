import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import java.util.concurrent.Semaphore;


public class Process extends Thread
{
    private int pID;
    private int baseCycle; //Starting frame of the process
    private int period; //Ex. Process1 has period of 2 it runs every other two seconds
    private boolean hasCS; //does process has critical section?
    private Burst[] cpuBurst;
    private Burst[] ioBurst;
    private ArrayList<Burst> bursts;
    private String time;
    private int memReq; //process size MB
	static Semaphore semaphore = new Semaphore(2);
	
    private Condition condition;
    // May need the declarations below later on
    // private static final int sysSpace = 256; // unit: MB
    // private int spaceAvail;
    
    public Process(int id,  boolean hasCS, int memory, ArrayList<Burst> burstsForProcess, int bc, int period,Condition cond )
    {
    	  this.pID = id;
    	  this.baseCycle = bc;
    	  this.period = period;
    	  this.hasCS = hasCS;
    	  this.bursts = burstsForProcess;
    	  this.memReq = memory;
    	  this.condition = cond;
    }

    public void newProc(int pID, boolean hasCS,int memReq, Burst[] cpuBurst, Burst[] ioBurst, int bc, int p, Condition condition)
    {
        this.pID = pID;
        this.hasCS = hasCS;
        this.memReq = memReq;
        this.cpuBurst = cpuBurst;
        this.ioBurst = ioBurst;
        this.setBaseCycle(bc);
        this.setPeriod(p);
        this.condition = condition;
    }

	public int getBaseCycle() 
	{
		return baseCycle;
	}
    
    public int getPid()
    {
        return pID;
    }
    public boolean getCS()
    {
        return hasCS;
    }
    public int getMemReq()
    {
        return memReq;
    }
    public Burst[] getCPUBurst()
    {
        return Arrays.copyOf(cpuBurst, cpuBurst.length);
    }
    public Burst[] getIOBurst()
    {
        return ioBurst;
    }
    
    public int getPeriod() 
	{
		return period;
	}

	public void setPeriod(int period) 
	{
		this.period = period;
	}

	public void setBaseCycle(int baseCycle) 
	{
		this.baseCycle = baseCycle;
	}

	public Condition getCondition() 
	{
		return condition;
	}

	public void setCondition(Condition condition) 
	{
		this.condition = condition;
	}

	@Override
	public void run() 
	{
	  boolean timeFlag = true;
	  while(timeFlag)
	  {
	        Calendar a = Calendar.getInstance();
	        int sec = a.get(Calendar.MILLISECOND);
	        System.out.println(this.baseCycle + ":" + sec);
	        int waitTime=0;
	    	try {
        		System.out.println("Acquiring..");
				semaphore.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        for(Burst c : this.bursts )
        {
	        	waitTime = c.getTotalTime();
	        	System.out.println("WaitTime: "+ waitTime);
	        //&& this.baseCycle == sec 
	        
			if(this.hasCS  && c.getCriticalSection() !=0 )
			{
				System.out.println("Process: "+this.pID+" --- Entered Critical Section");
				System.out.println("accessing: " + c.getData());
				timeFlag = false;
				try {
					Thread.sleep(c.getCriticalSection()*100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else
			{
				//System.out.println(this.hasCS);
			}
        }
			try {
	            Thread.sleep(waitTime);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			finally
			{
				System.out.println(this.pID + " : releasing lock...");
				semaphore.release();
				System.out.println(this.pID + " : available Semaphore permits now: "
							+ semaphore.availablePermits());
			}
	  }
		// TODO Auto-generated method stub
		
	}

}
