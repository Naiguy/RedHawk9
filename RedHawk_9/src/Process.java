import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.locks.Condition;

//import java.util.TimerTask;

public class Process extends Thread
{
    private int pID;
    private int baseCycle; //Starting frame of the process
    private int period; //Ex. Process1 has period of 2 it runs every other two seconds
    private boolean hasCS; //does process has critical section?
    private Burst[] cpuBurst;
    private Burst[] ioBurst;
    private String time;
    private int memReq; //process size MB

    private Condition condition;
    // May need the declarations below later on
    // private static final int sysSpace = 256; // unit: MB
    //private int spaceAvail;

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
	       
	        	//waitTime = b.getTotalTime();
	        	System.out.println("WaitTime: "+ waitTime);
	        
			if(this.hasCS && this.baseCycle == sec )
			{
				System.out.println("Process: "+this.pID+" --- Entered Critical Section");
				timeFlag = false;
				
			}
			else
			{
				//System.out.println(this.hasCS);
			}
	        
			try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	  }
		// TODO Auto-generated method stub
		
	}

}
