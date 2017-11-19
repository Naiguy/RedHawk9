public class MemoryManager {

	static byte [][] PhysicalMemory = new byte [2][1024];
	static byte [][] LogicalMemory = new byte [2][1024];
	//static byte [][] PageRef = new byte[1][]
	static int sysSpace = 512; //system space in MB
	int spaceAvail = 512;
	
	public int decrementMemory(Process newProcess) {
		//n = needed memory
		spaceAvail = spaceAvail - newProcess.getMemReq();
		return spaceAvail;
		
	}
	public int reallocateMemory(Process newProcess) {
		if(newProcess.getCondition() == Condition.FINISHED || newProcess.getCondition() == Condition.WAITING){
			spaceAvail = spaceAvail + newProcess.getMemReq();
			return spaceAvail;
		}
		else{
			return spaceAvail;
		}
	}
	
}
	//each process would create a 

