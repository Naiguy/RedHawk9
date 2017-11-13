
public class Simulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Process p1 = new Process();
		p1.newProc(72,false,2,4,4);


		System.out.println("Process p1 has a PID of: " + p1.getPid());
		System.out.println("Has a CS? " + (p1.getCS() ? "Yes" : "No"));
		System.out.println("Memory Requirement: " + p1.getMemReq());
		System.out.println("CPU Burst of: " + p1.getCPUBurst());
		System.out.println("IO Burst of: " + p1.getIOBurst());	
	}
}
