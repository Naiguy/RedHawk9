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

    private ArrayList<Burst> bursts;
    private String time;
    private int memReq; //process size MB
	static Semaphore semaphore = new Semaphore(2);
	private int totalBurstTime;
    private Condition condition;
    
    public Process(int id,  boolean hasCS, int memory, ArrayList<Burst> burstsForProcess, int bc, int period,Condition cond )
    {
    	  this.pID = id;
    	  this.baseCycle = bc;
    	  this.period = period;
    	  this.hasCS = hasCS;
    	  this.setBursts(burstsForProcess);
    	  this.memReq = memory;
    	  this.condition = cond;
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
	
	public ArrayList<Burst> getBursts() 
	{
		return bursts;
	}

	public void setBursts(ArrayList<Burst> bursts) 
	{
		this.bursts = bursts;
	}

	public int getTotalBurstTime()
	{
			return totalBurstTime;
	}
	
	public void setTotalBurstTime(int totalBurstTime)
	{
			this.totalBurstTime = totalBurstTime;
	}
	
	@Override
	public void run() 
	{
		Simulator sim = new Simulator();
		int minorCycle = sim.getMinorCycle();
		long sleepTime = 0;
		int minorCycleTime = 4000;

		System.out.println("IN RUN pID"+this.pID+": "+this.condition);
		System.out.println();

		while(this.condition == Condition.RUNNING)
		{
			 minorCycle = sim.getMinorCycle();
			 //do stuff with minor cycle
			if(this.hasCS)
			{
				System.out.println("Has Critical section pid" + this.pID);
			}
			
			try
			{
				int burst = 0; // index for burst array; 
				sleepTime =  (this.period)  * minorCycleTime;
				int subtractFromBurst = (int) sleepTime/1000;
				int length =this.bursts.get(burst).getLength(); 
				int NewBurstLength =  this.bursts.get(burst).getLength() - subtractFromBurst;
				this.bursts.get(burst).setLength(NewBurstLength);
				System.out.println("Burst"+burst+"For pid"+this.pID+ " Length : " + length);
				System.out.println();
				
				if(length <= 0)
				{
					burst++;
				}
				
				System.out.println("PID"+this.getPid()+". In run total bt time: " + this.getTotalBurstTime() +"at time: " + sim.getTime2());
				System.out.println();
				System.out.println("Sleeptime: " + sleepTime+ ". For P"+ this.pID);
				Thread.sleep(sleepTime);
			
			} 
			catch (InterruptedException e) 
			{
			e.printStackTrace();
			}
		}
	
	}
	
}
