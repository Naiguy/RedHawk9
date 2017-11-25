import java.util.ArrayList;

public class NUMANode {
	//each NUMA Node
	//Has its own local logical memory
	//and access to its own little processors (but I think we can work around that
	//each node has its own cache as well.
	//There's home node that contains a directory (we can put that in the
	//memory manager
	
	//Numa nodes are like houses on the same block.
	//ideally, you do everything on the same block, but you CAN travel.
	//
	
	// 4 nodes of 128
	
	//
	
	public int totalMemory;
	public int memoryUsed;
	ArrayList<Process> procs = new ArrayList<Process>();
	ArrayList<String> data = new ArrayList<String>();
	
	NUMANode(int mem) {
		memoryUsed = 0;
		totalMemory = mem;
	}
	
	public void useMem(Process proc) {
		if (canFit(proc.getMemReq())) {
			procs.add(proc);
			memoryUsed = memoryUsed - proc.getMemReq();
		}
		else {
			//do use alg to send elsewhere
		}
	}
	public void releaseMem(Process proc) {
		procs.remove(proc);
		memoryUsed = memoryUsed + proc.getMemReq();
	}
	
	public boolean canFit(int AmttoFit) {
		int n = memoryUsed + AmttoFit;
		if (n >= totalMemory) return false;
		else return true;
	}
	
	public boolean isFull() {
		if (totalMemory == memoryUsed) return true;
		else return false;
	}

	
	
	
	
	
	
	
	
	
}
