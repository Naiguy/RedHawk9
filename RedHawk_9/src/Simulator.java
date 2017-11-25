import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

//import java.util.List;
public class Simulator {

	Semaphore semaphore = new Semaphore(1);
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
				
	
//		Burst cpuBurstP1_1 = new Burst(BurstType.CPU,5 , 0, 0,null);
//		Burst cpuBurstP1_2 = new Burst(BurstType.CPU,4 , 0, 0,null);
//		Burst cpuBurstP1_3 = new Burst(BurstType.CPU,6 , 0, 0,null);
//		Burst ioBurstP1_1 = new Burst(BurstType.IO,5 ,0, 0,null);
//		Burst ioBurstP1_2 = new Burst(BurstType.IO,4 ,0, 0,null);
//		
		Bursts burstsP1 = new Bursts('C', 5, null,'I', 5, null,'C', 4, null,'I', 5, null,'C', 6, null);

//		Burst cpuBurstP2_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst cpuBurstP2_2 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst cpuBurstP2_3 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst ioBurstP2_1 = new Burst(BurstType.IO,6 ,0, 0,null);
//		Burst ioBurstP2_2 = new Burst(BurstType.IO,6 ,0, 0,null);
//		
		Bursts burstsP2 = new Bursts('C',3,null,'I',6, null,'C',3,null,'I',6, null, 'C',3,null);
		
//		Burst cpuBurstP3_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst cpuBurstP3_2 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst cpuBurstP3_3 = new Burst(BurstType.CPU,0 , 0, 0,null);
//		Burst ioBurstP3_1 = new Burst(BurstType.IO,6 ,0, 0,null);
//		Burst ioBurstP3_2 = new Burst(BurstType.IO,0 ,0, 0,null);
//		
		Bursts burstsP3 = new Bursts('C', 4, null,'I', 3, null,'C', 5, null );
		
//		Burst cpuBurstP4_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst cpuBurstP4_2 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst cpuBurstP4_3 = new Burst(BurstType.CPU,0 , 0, 0,null);
//		Burst ioBurstP4_1 = new Burst(BurstType.IO,6 ,0, 0,null);
//		Burst ioBurstP4_2 = new Burst(BurstType.IO,0 ,0, 0,null);
		
		Bursts burstsP4 = new Bursts('C', 2, null,'I', 6, null,'C', 2, null,'I', 8, null, 'C', 4, null);
		
//		Burst cpuBurstP5_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst cpuBurstP5_2 = new Burst(BurstType.CPU,1 , 3, 1,"D1");
//		Burst cpuBurstP5_3 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst ioBurstP5_1 = new Burst(BurstType.IO,3 ,0, 0,null);
//		Burst ioBurstP5_2 = new Burst(BurstType.IO,3 ,0, 0,null);
//		
		Bursts burstsP5 = new Bursts('C', 3, null,'I', 3, null,'C', 1, null,'I', 4, "D1",'C', 1, null,'I', 3, null,'C', 3, null);
		
//		Burst cpuBurstP6_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst cpuBurstP6_2 = new Burst(BurstType.CPU,1 , 3, 1,"D2");
//		Burst cpuBurstP6_3 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst ioBurstP6_1 = new Burst(BurstType.IO,2 ,0, 0,null);
//		Burst ioBurstP6_2 = new Burst(BurstType.IO,2 ,0, 0,null);
//			
		Bursts burstsP6 = new Bursts('C', 3, null,'I', 2, null,'C', 1, null,'C', 4, "D2",'i', 1, null,'I', 2, null,'C', 3, null);
		
//		Burst cpuBurstP7_1 = new Burst(BurstType.CPU,1 , 2, 1,"D1");
//		Burst cpuBurstP7_2 = new Burst(BurstType.CPU,1 , 2, 1,"D1");
//		Burst cpuBurstP7_3 = new Burst(BurstType.CPU,5 , 0, 0,null);
//		Burst ioBurstP7_1 = new Burst(BurstType.IO,3 ,0, 0,null);
//		Burst ioBurstP7_2 = new Burst(BurstType.IO,2 ,0, 0,null);
//			
		Bursts burstsP7 = new Bursts('C', 1, null,'C', 2, "D1",'C', 1, null,'I', 3, null,'C', 1, null,'I', 2, "D1",'C', 1, null,'I', 2, null,'C', 5, null);
		
//		Burst cpuBurstP8_1 = new Burst(BurstType.CPU,1 , 3, 1,"D2");
		
		Bursts burstsP8 = new Bursts('C', 1, null,'C', 3, "D2",'C', 1, null);
		
//		Burst cpuBurstP9_1 = new Burst(BurstType.CPU,6 , 0, 0,null);
//		Burst cpuBurstP9_2 = new Burst(BurstType.CPU, 7, 0, 0,null);
//		Burst ioBurstP9_1 = new Burst(BurstType.IO,15 ,0, 0,null);
//			
		Bursts burstsP9 = new Bursts('C', 6, null,'I', 15, null,'C', 7, null);

		
//		Burst cpuBurstP10_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst cpuBurstP10_2 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst cpuBurstP10_3 = new Burst(BurstType.CPU,3 , 0, 0,null);
//		Burst ioBurstP10_1 = new Burst(BurstType.IO,5,0, 0,null);
//		Burst ioBurstP10_2 = new Burst(BurstType.IO,5 ,0, 0,null);
//		
		Bursts burstsP10 = new Bursts('C', 3, null,   'I', 5, null,   'C', 3, null,   'I', 5, null,   'C', 3, null);

		
//		Burst cpuBurstP11_1 = new Burst(BurstType.CPU,8 , 0, 0,null);
//		Burst cpuBurstP11_2 = new Burst(BurstType.CPU,10 , 0, 0,null);
//		Burst ioBurstP11_1 = new Burst(BurstType.IO,6,0, 0,null);
//				
		Bursts burstsP11 = new Bursts('C', 8, null,   'I', 6, null,   'C', 10, null);
		
//		Burst cpuBurstP12_1 = new Burst(BurstType.CPU,1 , 0, 0,null);
//		Burst cpuBurstP12_2 = new Burst(BurstType.CPU,2 , 0, 0,null);
//		Burst cpuBurstP12_3 = new Burst(BurstType.CPU,2 , 0, 0,null);
//		Burst cpuBurstP12_4 = new Burst(BurstType.CPU,2 , 0, 0,null);
//		Burst ioBurstP12_1 = new Burst(BurstType.IO,3,0, 0,null);
//		Burst ioBurstP12_2 = new Burst(BurstType.IO,3,0, 0,null);
//		Burst ioBurstP12_3 = new Burst(BurstType.IO,3,0, 0,null);

		Bursts burstsP12 = new Bursts('C', 1, null,   'I', 3, null,   'C', 2, null,   'I', 3, null,   'C', 2, null,   	'I', 3, null,   'C', 2, null);
		
//		Burst cpuBurstP13_1 = new Burst(BurstType.CPU,15 , 0, 0,null);
//		Burst cpuBurstP13_2 = new Burst(BurstType.CPU,20 , 0, 0,null);
//		Burst ioBurstP13_1 = new Burst(BurstType.IO,6,0, 0,null);

		Bursts burstsP13 = new Bursts('C', 15, null,  'I', 6, null, 		'C', 20, null);
		
//		Burst[] p1CPUBurstTotal = {cpuBurstP1_1, cpuBurstP1_2, cpuBurstP1_3};
//		Burst[] p1IOBurstTotal = {ioBurstP1_1, ioBurstP1_2};
//		
//		Burst[] p2CPUBurstTotal = {cpuBurstP2_1, cpuBurstP2_2, cpuBurstP2_3};
//		Burst[] p2IOBurstTotal = {ioBurstP2_1, ioBurstP2_2};
//		
//		Burst[] p3CPUBurstTotal = {cpuBurstP3_1, cpuBurstP3_2, cpuBurstP3_3};
//		Burst[] p3IOBurstTotal = {ioBurstP3_1, ioBurstP3_2};
//		
//		Burst[] p4CPUBurstTotal = {cpuBurstP4_1, cpuBurstP4_2, cpuBurstP4_3};
//		Burst[] p4IOBurstTotal = {ioBurstP4_1, ioBurstP4_2};
//		
//		Burst[] p5CPUBurstTotal = {cpuBurstP5_1, cpuBurstP5_2, cpuBurstP5_3};
//		Burst[] p5IOBurstTotal = {ioBurstP5_1, ioBurstP5_2};
//		
//		Burst[] p6CPUBurstTotal = {cpuBurstP6_1, cpuBurstP6_2, cpuBurstP6_3};
//		Burst[] p6IOBurstTotal = {ioBurstP6_1, ioBurstP6_2};
//		
//		Burst[] p7CPUBurstTotal = {cpuBurstP7_1, cpuBurstP7_2, cpuBurstP7_3};
//		Burst[] p7IOBurstTotal = {ioBurstP7_1, ioBurstP7_2};
//		
//		Burst[] p8CPUBurstTotal = {cpuBurstP8_1};
//		Burst[] p8IOBurstTotal = {};
//		
//		Burst[] p9CPUBurstTotal = {cpuBurstP9_1,cpuBurstP9_2};
//		Burst[] p9IOBurstTotal = {ioBurstP9_1};
//		
//		Burst[] p10CPUBurstTotal = {cpuBurstP10_1,cpuBurstP10_2,cpuBurstP10_3};
//		Burst[] p10IOBurstTotal = {ioBurstP10_1,ioBurstP10_2};
//		
//		Burst[] p11CPUBurstTotal = {cpuBurstP11_1,cpuBurstP11_2};
//		Burst[] p11IOBurstTotal = {ioBurstP11_1};
//		
//		Burst[] p12CPUBurstTotal = {cpuBurstP12_1,cpuBurstP12_2,cpuBurstP12_3,cpuBurstP12_4};
//		Burst[] p12IOBurstTotal = {ioBurstP12_1,ioBurstP12_2,ioBurstP12_3};
//		
//		
//		Burst[] p13CPUBurstTotal = {cpuBurstP13_1,cpuBurstP13_2};
//		Burst[] p13IOBurstTotal = {ioBurstP13_1};
//		
//		
		Process p1 = new Process(1,false,32,burstsP1,0,1,Condition.WAITING);
		Process p2 = new Process(2,false,110,burstsP2,1,3,Condition.WAITING);
		Process p3 = new Process(3, false, 24, burstsP3,2,2,Condition.WAITING);
		Process p4 = new Process(4, false, 60,burstsP4,3,5,Condition.WAITING);
		Process p5 = new Process(5, true, 64,burstsP5,0,1,Condition.WAITING);
		Process p6 = new Process(6, true, 100, burstsP6,1,1,Condition.WAITING);
		Process p7 = new Process(7, true, 90, burstsP7,2,4,Condition.WAITING);
		Process p8 = new Process(8, true, 30,burstsP8,3,3,Condition.WAITING);
		Process p9 = new Process(9, false,60, burstsP9,0,1,Condition.WAITING);
		Process p10 = new Process(10, false,300, burstsP10 ,1,1,Condition.WAITING);
		Process p11 = new Process(11, false,224, burstsP11,1,1,Condition.WAITING);
		Process p12 = new Process(12, false,80, burstsP12,2,1,Condition.WAITING);
		Process p13 = new Process(13, false,120, burstsP13,2,1,Condition.WAITING);
		
//		p1.newProc(1,false,32,p1CPUBurstTotal,p1IOBurstTotal,0,1,Condition.WAITING);
//		p2.newProc(2,false,110,p2CPUBurstTotal,p2IOBurstTotal,1,3,Condition.WAITING);
//		p3.newProc(3, false, 24, p3CPUBurstTotal, p3IOBurstTotal,2,2,Condition.WAITING);
//		p4.newProc(4, false, 60, p4CPUBurstTotal, p4IOBurstTotal,3,5,Condition.WAITING);
//		p5.newProc(5, true, 64, p5CPUBurstTotal, p5IOBurstTotal,0,2,Condition.WAITING);
//		p6.newProc(6, true, 100, p6CPUBurstTotal, p6IOBurstTotal,1,1,Condition.WAITING);
//		p7.newProc(7, true, 90, p7CPUBurstTotal, p7IOBurstTotal,2,4,Condition.WAITING);
//		p8.newProc(8, true, 30, p8CPUBurstTotal, p8IOBurstTotal,3,3,Condition.WAITING);
//		p9.newProc(9, false,60, p9CPUBurstTotal, p9IOBurstTotal,0,1,Condition.WAITING);
//		p10.newProc(10, false,300, p10CPUBurstTotal, p10IOBurstTotal,1,1,Condition.WAITING);
//		p11.newProc(11, false,224, p11CPUBurstTotal, p11IOBurstTotal,1,1,Condition.WAITING);
//		p12.newProc(12, false,80, p12CPUBurstTotal, p12IOBurstTotal,2,1,Condition.WAITING);
//		p13.newProc(13, false,120, p13CPUBurstTotal, p13IOBurstTotal,2,1,Condition.WAITING);
//		System.out.println("Process p1 has a PID of: " + p1.getPid());
//		System.out.println("Has a CS? " + (p1.getCS() ? "Yes" : "No"));
//		System.out.println("Memory Requirement: " + p1.getMemReq());
//		System.out.println("CPU Burst of: " + p1.getCPUBurst());
//		System.out.println("IO Burst of: " + p1.getIOBurst());	

		
		ProcessScheduler pScheduler = new ProcessScheduler();
		
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
		
		StopWatch st = new StopWatch();
		st.start();
		//st.stop();
		
		int time = 0;
		while(st.getTime(TimeUnit.SECONDS) < 25)
		{
			time = (int) st.getTime(TimeUnit.SECONDS);
			System.out.println("@Time : " + time);
			for(int i = 0; i <Set2.size(); i ++)
			{
				ArrayList<Burst> burstArray = Set2.get(i).getBursts();
				System.out.println("PID"+Set2.get(i).getPid()+" Thread State for Thread : "+Set2.get(i).getId() + Set2.get(i).getState());
				Set2.get(i).setCondition(Condition.READY);
				
				
				
				
				
				System.out.println();
				if(Set2.get(i).getBaseCycle() == time)
				{
					System.out.println("The base cycle for p"+Set2.get(i).getPid()+" equals " + Set2.get(i).getBaseCycle() +  ". Starting Process");
					System.out.println("Time = " + time);
					if(Set2.get(i).getState() != Thread.State.TERMINATED) 
					{
						Set2.get(i).start();
					}
					
					int sum = 0;
					for (int j =0; j < burstArray.size(); j++)
					{
						
						sum = sum + burstArray.get(j).getLength();
						
						if(burstArray.get(j).getBt() == BurstType.IO)
						{
							System.out.println("Burst for pid"+Set2.get(i).getPid()+" "+burstArray.get(j) +" "+burstArray.get(j).getBt());
						}
						else 
						{
							System.out.println("Burst for pid"+Set2.get(i).getPid()+" "+burstArray.get(j) +" "+burstArray.get(j).getBt());
						}
					}
					System.out.println("Burst time total " + sum);
				}
				if(Set2.get(i).getCS())
				{
					System.out.println("Got CS " + Set2.get(i).getPid());
				}
			}
			
			Thread.sleep(1000);
		}
	}
}

