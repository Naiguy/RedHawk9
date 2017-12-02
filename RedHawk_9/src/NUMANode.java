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
	ArrayList<Process> doneProcs = new ArrayList<Process>();
	public NUMANode(int mem) 
	{
		memoryUsed = 0;
		totalMemory = mem;
	}
	
	public void useMem(Process proc) 
	{
		
		if(proc.getCondition() == Condition.RUNNING && !procs.contains(proc))
		{
			if (canFit(proc.getMemReq()))
			{	
			System.out.println("process"+proc.getPid()+" added " +proc.getMemReq() + "to numNode");
			procs.add(proc);
			memoryUsed = memoryUsed + proc.getMemReq();
			}
			else 
			{
				//do use alg to send elsewhere
			}
		}
		
	}
	public void releaseMem(Process proc) 
	{
		
		if(proc.getCondition() == Condition.TERMINATED && !doneProcs.contains(proc))
		{
		procs.remove(proc);
		memoryUsed = memoryUsed - proc.getMemReq();
		}
		doneProcs.add(proc);
		
	}
	
	public boolean canFit(int AmountToFit)
	{
		int n = memoryUsed + AmountToFit;
		if (n >= totalMemory) return false;
		else return true;
	}
	public int getMemoryUsed()
	{
		return memoryUsed;
	}
	public boolean isFull() 
	{
		if (totalMemory == memoryUsed) return true;
		else return false;
	}
	
	public int getAvailableMemory()
	{
		return totalMemory - memoryUsed;
	}
	
	public String checkBursts(Process pr)
	{
		String got;
		String product = null;
		for (int i = 0; i< pr.getBursts().size(); i++) 
			{
			got = pr.getBursts().get(i).getData();
			if (got != null) product = got;
			}
		return product;
	}
}
