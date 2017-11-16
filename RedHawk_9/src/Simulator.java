import java.util.ArrayList;
import java.util.List;

public class Simulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Burst cpuBurstP1_1 = new Burst(BurstType.CPU,5 , 0, 0,null);
		Burst cpuBurstP1_2 = new Burst(BurstType.CPU,4 , 0, 0,null);
		Burst cpuBurstP1_3 = new Burst(BurstType.CPU,6 , 0, 0,null);
		Burst ioBurstP1_1 = new Burst(BurstType.IO,5 ,0, 0,null);
		Burst ioBurstP1_2 = new Burst(BurstType.IO,4 ,0, 0,null);

		Burst cpuBurstP2_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst cpuBurstP2_2 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst cpuBurstP2_3 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst ioBurstP2_1 = new Burst(BurstType.IO,6 ,0, 0,null);
		Burst ioBurstP2_2 = new Burst(BurstType.IO,6 ,0, 0,null);
		
		Burst cpuBurstP3_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst cpuBurstP3_2 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst cpuBurstP3_3 = new Burst(BurstType.CPU,0 , 0, 0,null);
		Burst ioBurstP3_1 = new Burst(BurstType.IO,6 ,0, 0,null);
		Burst ioBurstP3_2 = new Burst(BurstType.IO,0 ,0, 0,null);
		
		Burst cpuBurstP4_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst cpuBurstP4_2 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst cpuBurstP4_3 = new Burst(BurstType.CPU,0 , 0, 0,null);
		Burst ioBurstP4_1 = new Burst(BurstType.IO,6 ,0, 0,null);
		Burst ioBurstP4_2 = new Burst(BurstType.IO,0 ,0, 0,null);
		
		Burst cpuBurstP5_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst cpuBurstP5_2 = new Burst(BurstType.CPU,1 , 3, 1,"D1");
		Burst cpuBurstP5_3 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst ioBurstP5_1 = new Burst(BurstType.IO,3 ,0, 0,null);
		Burst ioBurstP5_2 = new Burst(BurstType.IO,3 ,0, 0,null);
		
		Burst cpuBurstP6_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst cpuBurstP6_2 = new Burst(BurstType.CPU,1 , 3, 1,"D2");
		Burst cpuBurstP6_3 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst ioBurstP6_1 = new Burst(BurstType.IO,2 ,0, 0,null);
		Burst ioBurstP6_2 = new Burst(BurstType.IO,2 ,0, 0,null);
			
		Burst cpuBurstP7_1 = new Burst(BurstType.CPU,1 , 2, 1,"D1");
		Burst cpuBurstP7_2 = new Burst(BurstType.CPU,1 , 2, 1,"D1");
		Burst cpuBurstP7_3 = new Burst(BurstType.CPU,5 , 0, 0,null);
		Burst ioBurstP7_1 = new Burst(BurstType.IO,3 ,0, 0,null);
		Burst ioBurstP7_2 = new Burst(BurstType.IO,2 ,0, 0,null);
			
		Burst cpuBurstP8_1 = new Burst(BurstType.CPU,1 , 3, 1,"D2");
		
		Burst cpuBurstP9_1 = new Burst(BurstType.CPU,6 , 0, 0,null);
		Burst cpuBurstP9_2 = new Burst(BurstType.CPU, 7, 0, 0,null);
		Burst ioBurstP9_1 = new Burst(BurstType.IO,15 ,0, 0,null);
			
		
		
		Burst[] p1CPUBurstTotal = {cpuBurstP1_1, cpuBurstP1_2, cpuBurstP1_3};
		Burst[] p1IOBurstTotal = {ioBurstP1_1, ioBurstP1_2};
		
		Burst[] p2CPUBurstTotal = {cpuBurstP2_1, cpuBurstP2_2, cpuBurstP2_3};
		Burst[] p2IOBurstTotal = {ioBurstP2_1, ioBurstP2_2};
		
		Burst[] p3CPUBurstTotal = {cpuBurstP3_1, cpuBurstP3_2, cpuBurstP3_3};
		Burst[] p3IOBurstTotal = {ioBurstP3_1, ioBurstP3_2};
		
		Burst[] p4CPUBurstTotal = {cpuBurstP4_1, cpuBurstP4_2, cpuBurstP4_3};
		Burst[] p4IOBurstTotal = {ioBurstP4_1, ioBurstP4_2};
		
		Burst[] p5CPUBurstTotal = {cpuBurstP5_1, cpuBurstP5_2, cpuBurstP5_3};
		Burst[] p5IOBurstTotal = {ioBurstP5_1, ioBurstP5_2};
		
		Burst[] p6CPUBurstTotal = {cpuBurstP6_1, cpuBurstP6_2, cpuBurstP6_3};
		Burst[] p6IOBurstTotal = {ioBurstP6_1, ioBurstP6_2};
		
		Burst[] p7CPUBurstTotal = {cpuBurstP7_1, cpuBurstP7_2, cpuBurstP7_3};
		Burst[] p7IOBurstTotal = {ioBurstP7_1, ioBurstP7_2};
		
		Burst[] p8CPUBurstTotal = {cpuBurstP8_1};
		Burst[] p8IOBurstTotal = {};
		
		Burst[] p9CPUBurstTotal = {cpuBurstP9_1,cpuBurstP9_2};
		Burst[] p9IOBurstTotal = {ioBurstP9_1};
		
		
		Process p1 = new Process();
		Process p2 = new Process();
		Process p3 = new Process();
		Process p4 = new Process();
		Process p5 = new Process();
		Process p6 = new Process();
		Process p7 = new Process();
		Process p8 = new Process();
		Process p9 = new Process();

		p1.newProc(1,false,732,p1CPUBurstTotal,p1IOBurstTotal);
		p2.newProc(2,false,110,p2CPUBurstTotal,p2IOBurstTotal);
		p3.newProc(3, false, 24, p3CPUBurstTotal, p3IOBurstTotal);
		p4.newProc(4, false, 60, p4CPUBurstTotal, p4IOBurstTotal);
		p5.newProc(5, true, 64, p5CPUBurstTotal, p5IOBurstTotal);
		p6.newProc(6, true, 100, p6CPUBurstTotal, p6IOBurstTotal);
		p7.newProc(7, true, 90, p7CPUBurstTotal, p7IOBurstTotal);
		p8.newProc(8, true, 30, p8CPUBurstTotal, p8IOBurstTotal);
		p9.newProc(9, false,60, p9CPUBurstTotal, p9IOBurstTotal);

		System.out.println("Process p1 has a PID of: " + p1.getPid());
		System.out.println("Has a CS? " + (p1.getCS() ? "Yes" : "No"));
		System.out.println("Memory Requirement: " + p1.getMemReq());
		System.out.println("CPU Burst of: " + p1.getCPUBurst());
		System.out.println("IO Burst of: " + p1.getIOBurst());	
		
		ArrayList<Process> Set1 = new ArrayList<Process>();
		Set1.add(p1);
		Set1.add(p2);
		Set1.add(p3);
		Set1.add(p4);
		
		ArrayList<Process> Set2 = new ArrayList<Process>();

		

	}
}
