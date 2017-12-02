import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Calendar;

//import java.util.concurrent.Semaphore;

//import javax.swing.text.html.HTMLDocument.Iterator;


public class Process extends Thread
{
    private int pID;
    private int baseCycle; //Starting frame of the process
    private int period; //Ex. Process1 has period of 2 it runs every other two seconds
    private boolean hasCS; //does process has critical section?

    private ArrayList<Burst> bursts;
    //private String time;
    private int memReq; //process size MB
	//static Semaphore semaphore = new Semaphore(2);
	private int totalBurstTime;
    public Condition condition;
    private int csStartTime ;
    public boolean csFlag = false;
    public Process(int id,  boolean hasCS, int memory, ArrayList<Burst> burstsForProcess, int bc, int period,Condition cond)
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
		long sleepTime = 0;
		int minorCycleTime = 4000;
		
		while(this.condition == Condition.RUNNING)
		{
			int time = sim.getTime2();	
			 //do stuff with minor cycle
			//System.out.println("Queue Length: " + sem.getQueueLength());
			if(this.hasCS)
			{
//				System.out.println();
//				System.out.println("Has Critical section pid" + this.pID);
				try
				{
					/*
					 * The reason these are not 
					 */
					try
					{
						Sync.getLock(); // get  lock from semaphore from Sync class 
						int thisPeriod = this.period-1;
						
						if(thisPeriod == 0)
						{
							thisPeriod = 1;
						}
						//this.condition = Condition.CS;
						
						if(this.totalBurstTime == 1)
						{
							System.out.println("P"+this.pID);
						}
						
						int burst = 0; // index for burst array; 
						sleepTime =  thisPeriod  * minorCycleTime;
						int subtractFromBurst = (int) sleepTime/1000;
						//System.out.println("Subtract from burst length =" + subtractFromBurst);
						int length =this.bursts.get(burst).getLength(); 
						int NewBurstLength =  length - subtractFromBurst;
						this.bursts.get(burst).setLength(NewBurstLength);
						
						
						java.util.Iterator<Burst> iterator = this.bursts.iterator();
						while(iterator.hasNext())
						{
						    Burst b = (Burst) iterator.next();
						    
							if(b.getData() != null && !csFlag)
						    {
								csFlag=true;
								System.out.println("P"+this.pID+" Accessing " + b.getData());
						    }
						    if(b.getLength() <= 0)
						    {
						    		iterator.remove();
						    }

						}
						Process.sleep(sleepTime);						
					 } 
					 finally 
					 {
							Sync.releaseLock();
							System.out.println("Releasing lock");
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
