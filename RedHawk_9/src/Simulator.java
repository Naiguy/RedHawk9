import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

//import java.util.List;
public class Simulator {

	public static Semaphore semaphore = new Semaphore(1);
	public static int minorCycle = 0;
	public static int minorCycleLength = 3; // actually is 4 but because we start at 0 3 is essentially 4 
	public static int minorCycleRemainder = (minorCycleLength % 4);
	public static StopWatch st = new StopWatch();
	public static int time = 0;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException 
	{
	
		Bursts burstsP1 = new Bursts('C', 5, null,   'I', 5, null,   'C', 4, null,   'I', 5, null,   'C', 6, null);
	
		Bursts burstsP2 = new Bursts('C', 3, null,   'I',6, null,    'C',3,null,     'I',6, null,    'C',3,null);

		Bursts burstsP3 = new Bursts('C', 4, null,   'I', 3, null,   'C', 5, null );
	
		Bursts burstsP4 = new Bursts('C', 2, null,   'I', 6, null,   'C', 2, null,   'I', 8, null,    'C', 4, null);
	
		Bursts burstsP5 = new Bursts('C', 3, null,   'I', 3, null,   'C', 1, null   ,'I', 4, "D1",   'C', 1, null,   'I', 3, null,   'C', 3, null);
		
		Bursts burstsP6 = new Bursts('C', 3, null,   'I', 2, null,   'C', 1, null,   'C', 4, "D2",   'I', 1, null,   'I', 2, null   ,'C', 3, null);
		
		Bursts burstsP7 = new Bursts('C', 1, null,   'C', 2, "D1",   'C', 1, null   ,'I', 3, null,   'C', 1, null,   'I', 2, "D1",   'C', 1, null,   'I', 2, null,   'C', 5, null);
				
		Bursts burstsP8 = new Bursts('C', 1, null,   'C', 3, "D2",   'C', 1, null);

		Bursts burstsP9 = new Bursts('C', 6, null,   'I', 15, null,   'C', 7, null);
		
		Bursts burstsP10 = new Bursts('C', 3, null,   'I', 5, null,   'C', 3, null,   'I', 5, null,   'C', 3, null);
		
		Bursts burstsP11 = new Bursts('C', 8, null,   'I', 6, null,   'C', 10, null);

		Bursts burstsP12 = new Bursts('C', 1, null,   'I', 3, null,   'C', 2, null,   'I', 3, null,   'C', 2, null,   	'I', 3, null,   'C', 2, null);
		
		Bursts burstsP13 = new Bursts('C', 15, null,  'I', 6, null,   'C', 20, null);
			
		Process p1 = new Process(1,false,32,burstsP1,0,1,Condition.WAITING);
		Process p2 = new Process(2,false,110,burstsP2,1,3,Condition.WAITING);
		Process p3 = new Process(3, false, 24, burstsP3,2,2,Condition.WAITING);
		Process p4 = new Process(4, false, 60,burstsP4,3,5,Condition.WAITING);
		Process p5 = new Process(5, true, 64,burstsP5,0,1,Condition.WAITING);
		Process p6 = new Process(6, true, 100, burstsP6,1,1,Condition.WAITING);
		Process p7 = new Process(7, true, 90, burstsP7,2,2,Condition.WAITING);
		Process p8 = new Process(8, true, 30,burstsP8,3,3,Condition.WAITING);
		Process p9 = new Process(9, false,60, burstsP9,0,1,Condition.WAITING);
		Process p10 = new Process(10, false,300, burstsP10 ,1,1,Condition.WAITING);
		Process p11 = new Process(11, false,224, burstsP11,1,1,Condition.WAITING);
		Process p12 = new Process(12, false,80, burstsP12,2,1,Condition.WAITING);
		Process p13 = new Process(13, false,120, burstsP13,2,1,Condition.WAITING);
		
	//	ProcessScheduler pScheduler = new ProcessScheduler();
		
		//p1.getCPUBurst();
		ArrayList<Process> Set1 = new ArrayList<Process>();
		Set1.add(p1);
		Set1.add(p2);
		Set1.add(p3);
		Set1.add(p4);
		
		ArrayList<Process> Set2 = new ArrayList<Process>();
		Set2.add(p5);
		Set2.add(p6);
		Set2.add(p7);
		Set2.add(p8);

		ArrayList<Process> Set3 = new ArrayList<Process>();
		Set3.add(p9);
		Set3.add(p10);
		Set3.add(p11);
		Set3.add(p12);
		Set3.add(p13);
		
		st.start();		
		
		ArrayList<Process> waitingQ = new ArrayList<Process>();
		ArrayList<Process> readyQ = new ArrayList<Process>();
		ArrayList<Process> runningQ = new ArrayList<Process>();
		
//		NUMANode numNode = new NUMANode(512);
//		while(st.getTime(TimeUnit.SECONDS) <= 80)
//		{
//			waitingQ = new ArrayList<Process>();
//			readyQ = new ArrayList<Process>();
//			runningQ = new ArrayList<Process>();
//			time = (int) st.getTime(TimeUnit.SECONDS);
//			System.out.println("@Time : " + time);
//			//System.out.println();
//			
//			if(time % 4 == minorCycleRemainder)
//			{
//				System.out.println("Minor Cycle: " + minorCycle+ " over. Time  : " + time );
//				minorCycle++;
//				minorCycleLength+=4;
//			}
//			for(Process process : Set1)
//			{
//				
//				
//				ArrayList<Burst> burstArray = process.getBursts();
//				int burstTotal = 0;
//				
//				for (int j =0; j < burstArray.size(); j++) // getting the burst time
//				{
//					burstTotal = burstTotal + burstArray.get(j).getLength();
//				}
//				
//				if(burstTotal <= 0)
//				{
//					process.setCondition(Condition.TERMINATED);
//				}
//								
//				//System.out.println("Burst time total for Process"+ process.getPid() +" :"+ sum);
//				process.setTotalBurstTime(burstTotal);
//				if(burstTotal > 0)
//				{
//					//System.out.println("Burst time total for Process"+ process.getPid() +" :"+process.getTotalBurstTime());
//				}
//				//System.out.println();
//
//				if(process.getState() == Thread.State.NEW && process.getBaseCycle() == minorCycle && numNode.canFit(process.getMemReq())) 
//				{
//					process.setCondition(Condition.RUNNING);
//					process.start();	
//				}
//				
//				
//				if(process.getCondition() == Condition.RUNNING)
//				{
//					numNode.useMem(process);
//				}
//				
//				
//				if(process.getCondition() == Condition.TERMINATED)
//				{
//					numNode.releaseMem(process);
//				}
//				
//			}
//			
//
//			for(Process process : Set1)
//			{
//				if(process.getCondition() == Condition.WAITING)
//				{
//					waitingQ.add(process);
//				}
//				else if(process.getCondition() == Condition.READY)
//				{
//					readyQ.add(process);
//				}
//				else if(process.getCondition() == Condition.RUNNING)
//				{
//					runningQ.add(process);
//				}
//			}
//			
//			if(!runningQ.isEmpty())
//			{
//
//				//System.out.println();
//				System.out.print("CPU Usage:" );
//				for(Process process : runningQ)
//				{	
//					System.out.print("P"+process.getPid() +" ");
//				}
//				System.out.println("running");
//			}
//			
//			
//			if(!waitingQ.isEmpty())
//			{
//				System.out.println("waitingQ: ");
//				for(Process process : waitingQ)
//				{	
//					System.out.print("P"+process.getPid() +" ");
//				}
//				//System.out.println();
//			}
//			else
//			{
//				System.out.println("waitingQ: -");
//			}
//			
//			if(!readyQ.isEmpty())
//			{
//
//				//System.out.println();
//				System.out.println("Processes in readyQ " );
//				for(Process process : readyQ)
//				{	
//					System.out.print("P"+process.getPid() +" ");
//				}
//				//System.out.println();
//
//			}
//			else
//			{
//				System.out.println("readyQ: -");
//			}
//			
//			System.out.println("Memory Usage:");
//			System.out.println("\t used Space" + numNode.memoryUsed);
//			System.out.println("\t NUMA Node available use: "+numNode.getTotalMemory());
//			
//			
//		
//			
//			
//			Thread.sleep(1000); //Sleep one second for the stopwatch timer 
//		}
		
		
		
//=========================Run for set 1 completed running set2 starting ============================
//==============================		==============================		==============================		
		
		
		
//		System.out.println("=========================Run for set 1 completed running set2 starting ============================");
//		st.reset();
//		st.start();
//		while(st.getTime(TimeUnit.SECONDS) <= 100)
//		{
//			waitingQ = new ArrayList<Process>();
//			readyQ = new ArrayList<Process>();
//			runningQ = new ArrayList<Process>();
//			time = (int) st.getTime(TimeUnit.SECONDS);
//			System.out.println("@Time : " + time);
//			//System.out.println();
//			
//			if(time % 4 == minorCycleRemainder)
//			{
//				System.out.println("Minor Cycle: " + minorCycle+ " over. Time  : " + time );
//				minorCycle++;
//				minorCycleLength+=4;
//			}
//			for(Process process : Set2)
//			{
//				
//				
//				ArrayList<Burst> burstArray = process.getBursts();
//				int burstTotal = 0;
//				
//				for (int j =0; j < burstArray.size(); j++) // getting the burst time
//				{
//					burstTotal = burstTotal + burstArray.get(j).getLength();
//				}
//				
//				if(burstTotal <= 0)
//				{
//					process.setCondition(Condition.TERMINATED);
//				}
//								
//				//System.out.println("Burst time total for Process"+ process.getPid() +" :"+ sum);
//				process.setTotalBurstTime(burstTotal);
//				if(burstTotal > 0)
//				{
//					//System.out.println("Burst time total for Process"+ process.getPid() +" :"+process.getTotalBurstTime());
//				}
//				//System.out.println();
//
//				if(process.getState() == Thread.State.NEW && process.getBaseCycle() == minorCycle) 
//				{
//					process.setCondition(Condition.RUNNING);
//					process.start();	
//				}
//				if(process.getState() == Thread.State.BLOCKED || process.getState() == Thread.State.TERMINATED
//						|| process.getState() == Thread.State.WAITING)
//				{
//					System.out.println("P" + process.getPid() +"=========" + process.getState() +" "+ process.getCondition());
//					//process.start();
//					
//				}
//				
//				if(process.getId() == 7 && process.getState() == Thread.State.WAITING)
//				{
//					process.resume();
//					System.out.println("P" + process.getPid() +"=========" + process.getState());
//					System.out.println("@@@@@@@@@@@@@@@@@@@@@");
//				}
////				if(time > 25)
////				{
////					process.setCondition(Condition.WAITING);
////				}
//				
//			}
//			
//
//			for(Process process : Set2)
//			{
//				if(process.getCondition() == Condition.WAITING)
//				{
//					waitingQ.add(process);
//				}
//				else if(process.getCondition() == Condition.READY)
//				{
//					readyQ.add(process);
//				}
//				else if(process.getCondition() == Condition.RUNNING)
//				{
//					runningQ.add(process);
//				}
//			}
//			
//			if(!runningQ.isEmpty())
//			{
//
//				//System.out.println();
//				System.out.print("CPU Usage:" );
//				for(Process process : runningQ)
//				{	
//					System.out.print("P"+process.getPid() +" ");
//				}
//				System.out.println("running");
//			}
//			
//			
//			if(!waitingQ.isEmpty())
//			{
//				System.out.print("waitingQ: ");
//				for(Process process : waitingQ)
//				{	
//					System.out.print("P"+process.getPid() +" ");
//				}
//				//System.out.println();
//			}
//			else
//			{
//				System.out.println("waitingQ: -");
//			}
//			
//			if(!readyQ.isEmpty())
//			{
//
//				//System.out.println();
//				System.out.println("Processes in readyQ " );
//				for(Process process : readyQ)
//				{	
//					System.out.print("P"+process.getPid() +" ");
//				}
//				//System.out.println();
//
//			}
//			else
//			{
//				System.out.println("readyQ: -");
//			}
//			
//			
//			
//			
//			System.out.println();
//						
//			Thread.sleep(1000); //Sleep one second for the stopwatch timer 
//		}
//		
		
		
//===============================================================================================
		System.out.println("Starting set 3 =========================================================================");
		
		
		
		
		NUMANode numNode = new NUMANode(512);
		while(st.getTime(TimeUnit.SECONDS) <= 80)
		{
			waitingQ = new ArrayList<Process>();
			readyQ = new ArrayList<Process>();
			runningQ = new ArrayList<Process>();
			time = (int) st.getTime(TimeUnit.SECONDS);
			System.out.println("@Time : " + time);
			//System.out.println();
			
			if(time % 4 == minorCycleRemainder)
			{
				System.out.println("Minor Cycle: " + minorCycle+ " over. Time  : " + time );
				minorCycle++;
				minorCycleLength+=4;
			}
			for(Process process : Set3)
			{
				
				
				ArrayList<Burst> burstArray = process.getBursts();
				int burstTotal = 0;
				
				for (int j =0; j < burstArray.size(); j++) // getting the burst time
				{
					burstTotal = burstTotal + burstArray.get(j).getLength();
				}
				
				if(burstTotal <= 0)
				{
					process.setCondition(Condition.TERMINATED);
				}
								
				//System.out.println("Burst time total for Process"+ process.getPid() +" :"+ sum);
				process.setTotalBurstTime(burstTotal);
				if(burstTotal > 0)
				{
					//System.out.println("Burst time total for Process"+ process.getPid() +" :"+process.getTotalBurstTime());
				}
				//System.out.println();

				if(process.getState() == Thread.State.NEW && process.getBaseCycle() == minorCycle && numNode.canFit(process.getMemReq())) 
				{
					process.setCondition(Condition.RUNNING);
					process.start();	
				}
				
				if(process.getState() == Thread.State.NEW && process.getBaseCycle() < minorCycle && minorCycle > 7 && numNode.canFit(process.getMemReq()))
				{
					process.setCondition(Condition.RUNNING);
					process.start();	
				}
				
				
				if(process.getCondition() == Condition.RUNNING)
				{
					numNode.useMem(process);
				}
				
				
				if(process.getCondition() == Condition.TERMINATED)
				{
					numNode.releaseMem(process);
				}
				
			}
			

			for(Process process : Set3)
			{
				if(process.getCondition() == Condition.WAITING)
				{
					waitingQ.add(process);
				}
				else if(process.getCondition() == Condition.READY)
				{
					readyQ.add(process);
				}
				else if(process.getCondition() == Condition.RUNNING)
				{
					runningQ.add(process);
				}
			}
			
			if(!runningQ.isEmpty())
			{

				//System.out.println();
				System.out.print("CPU Usage:" );
				for(Process process : runningQ)
				{	
					System.out.print("P"+process.getPid() +" ");
				}
				System.out.println("running");
			}
			
			
			if(!waitingQ.isEmpty())
			{
				System.out.println("waitingQ: ");
				for(Process process : waitingQ)
				{	
					System.out.print("P"+process.getPid() +" ");
				}
				//System.out.println();
			}
			else
			{
				System.out.println("waitingQ: -");
			}
			
			if(!readyQ.isEmpty())
			{

				//System.out.println();
				System.out.println("Processes in readyQ " );
				for(Process process : readyQ)
				{	
					System.out.print("P"+process.getPid() +" ");
				}
				//System.out.println();

			}
			else
			{
				System.out.println("readyQ: -");
			}
			
			System.out.println("Memory Usage:");
			System.out.println("\t used Space" + numNode.memoryUsed);
			System.out.println("\t NUMA Node available use: "+numNode.getTotalMemory());
			
			
		
			
			
			Thread.sleep(1000); //Sleep one second for the stopwatch timer 
		}
		
		
		
	}//end main
	
	public Semaphore getSem()
	{
		semaphore = new Semaphore(1);
		return semaphore;
	}
	
	public int getMinorCycle()
	{
		return minorCycle;
	}
	public int getTime2()
	{
		return time;
	}
}

