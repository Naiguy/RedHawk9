
public class Simulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Burst cpuBurst = new Burst(BurstType.CPU,2 ,5, 6);
		Burst[] p1CPUBurstTotal = {cpuBurst};
		Burst ioBurst = new Burst(BurstType.IO,2 ,0, 6);
		Burst[] p1IOBurst = {ioBurst};
		
		
		Process p1 = new Process();
		p1.newProc(72,false,2,p1CPUBurstTotal,p1IOBurst);


		System.out.println("Process p1 has a PID of: " + p1.getPid());
		System.out.println("Has a CS? " + (p1.getCS() ? "Yes" : "No"));
		System.out.println("Memory Requirement: " + p1.getMemReq());
		System.out.println("CPU Burst of: " + p1.getCPUBurst());
		System.out.println("IO Burst of: " + p1.getIOBurst());	
	}
}
