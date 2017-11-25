public class MemoryManager {
	
	MemoryManager() {
		NUMANode nodeX = new NUMANode(256);
		NUMANode nodeY = new NUMANode(256);
	}

	static int physicalMemory[] = new int[512];
	static int sysSpace = 512; //system space in MB
	int spaceAvail = 512;
	
	public int decrementMemory(Process newProcess) {
		//n = needed memory
		spaceAvail = spaceAvail - newProcess.getMemReq();
		return spaceAvail;
	}
	
	public NUMANode whereGo (Process pr, NUMANode x, NUMANode y) {
		//decides which node to put process
		for (int i = 0; i<4000; i++) {
			
		}
		
		return x;
	}
	
	public int reallocateMemory(Process newProcess) {
		if(newProcess.getCondition() == Condition.FINISHED || newProcess.getCondition() == Condition.WAITING)
		{
			spaceAvail = spaceAvail + newProcess.getMemReq();
			return spaceAvail;
		}
		else{
			return spaceAvail;
		}
	}
	
}


