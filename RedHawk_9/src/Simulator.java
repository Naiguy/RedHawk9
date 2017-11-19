import java.util.ArrayList;
//import java.util.List;

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
			
		Burst cpuBurstP10_1 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst cpuBurstP10_2 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst cpuBurstP10_3 = new Burst(BurstType.CPU,3 , 0, 0,null);
		Burst ioBurstP10_1 = new Burst(BurstType.IO,5,0, 0,null);
		Burst ioBurstP10_2 = new Burst(BurstType.IO,5 ,0, 0,null);
		
		Burst cpuBurstP11_1 = new Burst(BurstType.CPU,8 , 0, 0,null);
		Burst cpuBurstP11_2 = new Burst(BurstType.CPU,10 , 0, 0,null);
		Burst ioBurstP11_1 = new Burst(BurstType.IO,6,0, 0,null);
				
		Burst cpuBurstP12_1 = new Burst(BurstType.CPU,1 , 0, 0,null);
		Burst cpuBurstP12_2 = new Burst(BurstType.CPU,2 , 0, 0,null);
		Burst cpuBurstP12_3 = new Burst(BurstType.CPU,2 , 0, 0,null);
		Burst cpuBurstP12_4 = new Burst(BurstType.CPU,2 , 0, 0,null);
		Burst ioBurstP12_1 = new Burst(BurstType.IO,3,0, 0,null);
		Burst ioBurstP12_2 = new Burst(BurstType.IO,3,0, 0,null);
		Burst ioBurstP12_3 = new Burst(BurstType.IO,3,0, 0,null);

		Burst cpuBurstP13_1 = new Burst(BurstType.CPU,15 , 0, 0,null);
		Burst cpuBurstP13_2 = new Burst(BurstType.CPU,20 , 0, 0,null);
		Burst ioBurstP13_1 = new Burst(BurstType.IO,6,0, 0,null);


		
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
		
		Burst[] p10CPUBurstTotal = {cpuBurstP10_1,cpuBurstP10_2,cpuBurstP10_3};
		Burst[] p10IOBurstTotal = {ioBurstP10_1,ioBurstP10_2};
		
		Burst[] p11CPUBurstTotal = {cpuBurstP11_1,cpuBurstP11_2};
		Burst[] p11IOBurstTotal = {ioBurstP11_1};
		
		Burst[] p12CPUBurstTotal = {cpuBurstP12_1,cpuBurstP12_2,cpuBurstP12_3,cpuBurstP12_4};
		Burst[] p12IOBurstTotal = {ioBurstP12_1,ioBurstP12_2,ioBurstP12_3};
		
		
		Burst[] p13CPUBurstTotal = {cpuBurstP13_1,cpuBurstP13_2};
		Burst[] p13IOBurstTotal = {ioBurstP13_1};
		
		
		Process p1 = new Process();
		Process p2 = new Process();
		Process p3 = new Process();
		Process p4 = new Process();
		Process p5 = new Process();
		Process p6 = new Process();
		Process p7 = new Process();
		Process p8 = new Process();
		Process p9 = new Process();
		Process p10 = new Process();
		Process p11 = new Process();
		Process p12 = new Process();
		Process p13 = new Process();

		p1.newProc(1,false,732,p1CPUBurstTotal,p1IOBurstTotal,0,1);
		p2.newProc(2,false,110,p2CPUBurstTotal,p2IOBurstTotal,1,3);
		p3.newProc(3, false, 24, p3CPUBurstTotal, p3IOBurstTotal,2,2);
		p4.newProc(4, false, 60, p4CPUBurstTotal, p4IOBurstTotal,3,5);
		p5.newProc(5, true, 64, p5CPUBurstTotal, p5IOBurstTotal,0,2);
		p6.newProc(6, true, 100, p6CPUBurstTotal, p6IOBurstTotal,1,1);
		p7.newProc(7, true, 90, p7CPUBurstTotal, p7IOBurstTotal,2,4);
		p8.newProc(8, true, 30, p8CPUBurstTotal, p8IOBurstTotal,3,3);
		p9.newProc(9, false,60, p9CPUBurstTotal, p9IOBurstTotal,0,1);
		p10.newProc(10, false,300, p10CPUBurstTotal, p10IOBurstTotal,1,1);
		p11.newProc(11, false,224, p11CPUBurstTotal, p11IOBurstTotal,1,1);
		p12.newProc(12, false,80, p12CPUBurstTotal, p12IOBurstTotal,2,1);
		p13.newProc(13, false,120, p13CPUBurstTotal, p13IOBurstTotal,2,1);

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
		
		

	}
}
