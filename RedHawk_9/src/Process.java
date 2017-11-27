import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import java.util.concurrent.Semaphore;

import javax.swing.text.html.HTMLDocument.Iterator;


public class Process extends Thread
{
    private int pID;
    private int baseCycle; //Starting frame of the process
    private int period; //Ex. Process1 has period of 2 it runs every other two seconds
    private boolean hasCS; //does process has critical section?

    private ArrayList<Burst> bursts;
    private String time;
    private int memReq; //process size MB
	//static Semaphore semaphore = new Semaphore(2);
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
		Semaphore sem;

		while(this.condition == Condition.RUNNING)
		{
			 minorCycle = sim.getMinorCycle();
			 //do stuff with minor cycle
			sem = sim.getSem();
			if(this.hasCS)
			{
				System.out.println();
				System.out.println("Has Critical section pid" + this.pID);
				
				try
				{
					
					try
					{
						int thisPeriod = this.period-1;
						
						if(thisPeriod == 0)
						{
							thisPeriod = 1;
						}
						
						int burst = 0; // index for burst array; 
						sleepTime =  thisPeriod  * minorCycleTime;
						int subtractFromBurst = (int) sleepTime/1000;
						//System.out.println("Subtract from burst length =" + subtractFromBurst);
						int length =this.bursts.get(burst).getLength(); 
						int NewBurstLength =  length - subtractFromBurst;
						this.bursts.get(burst).setLength(NewBurstLength);
						
						
						java.util.Iterator<Burst> iterator = this.bursts.iterator();
						//System.out.println("data for p"+this.getId());
						while(iterator.hasNext())
						{
						    Burst b = (Burst) iterator.next();
							System.out.print(b.getData());
						    if(b.getData() != null)
						    {
						    		sem.acquire();
						    		System.out.println("Counting Semaphore acquired");
						    }
						    if(b.getLength() <= 0)
						    {
						    		iterator.remove();
						    }

						}
						System.out.println();
						System.out.println("Run P"+this.pID+ " Condition:" + this.condition );
						Process.sleep(sleepTime);
					
					} 
					 finally 
					 {

							// calling release() after a successful acquire()
							System.out.println("P"+this.pID + " : releasing lock...");
							sem.release();
							System.out.println("P"+this.pID  + " : available Semaphore permits now: "
										+ sem.availablePermits());
							//this.condition = Condition.WAITING;
							
							
							System.out.println("Finally  P"+this.pID+ " Condition:" + this.condition );

					}
				}
				catch (InterruptedException e) 
				{
				e.printStackTrace();
				}
				
			}
			else
			{
				try
				{
					int thisPeriod = this.period-1;
					
					if(thisPeriod == 0)
					{
						thisPeriod = 1;
					}
					
					int burst = 0; // index for burst array; 
					sleepTime =  thisPeriod  * minorCycleTime;
					int subtractFromBurst = (int) sleepTime/1000;
					//System.out.println("Subtract from burst length =" + subtractFromBurst);
					int length =this.bursts.get(burst).getLength(); 
					int NewBurstLength =  length - subtractFromBurst;
					this.bursts.get(burst).setLength(NewBurstLength);
					//System.out.println("Burst"+burst+" For pid"+this.pID+ " Length : " + NewBurstLength);
					//System.out.println();
					
					
					java.util.Iterator<Burst> iterator = this.bursts.iterator();
					//System.out.println("data for p"+this.getId());
					while(iterator.hasNext())
					{
					    Burst b = (Burst) iterator.next();
						
					    if(b.getLength() <= 0)
					    {
					    		iterator.remove();
					    }

					}
					System.out.println();
					Thread.sleep(sleepTime);
				
				}
				catch (InterruptedException e) 
				{
				e.printStackTrace();
				}
			}
		}
	
	}
	
}
