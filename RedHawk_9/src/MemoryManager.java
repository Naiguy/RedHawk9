import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class MemoryManager {
	

	public static int physicalMemory[] = new int[1024];
	private static ArrayList<Integer> pages = new ArrayList<Integer>();
	public static int sysSpace = 1024; //system space in MB
	public static int spaceAvail = 1024;
	
	//pages are booleans and physical memory attach to pages
	//implements firstfit
	public void initializePhysMem() {
		for (int i = 0; i < physicalMemory.length; i++) {
			physicalMemory[i] = 0;
		}
	}
	
	public static boolean usePhysical(Process pr, int pageId) {
		int memoryNeeded = pr.getMemReq();
		int pageNum = pageId;
		boolean found = false;
		int start = 0;
		int end = 0;
		int memoryPointer = 0;
		int memoryFound = 0;
		while (found == false) 
		{
		while (physicalMemory[memoryPointer] != 0) //look for empty physicalMemory							
		{
			memoryPointer = memoryPointer + 4;
		}
		start = memoryPointer;
		while (physicalMemory[memoryPointer] == 0 ) 
			{
			//System.out.println("Entered");
			memoryPointer = memoryPointer + 4;
			memoryFound = memoryFound + 4;
			if (memoryFound == memoryNeeded) 
				{
				found = true;
				}
			end = memoryPointer;
			}	
		}
		if (found) 
			{
				int j = 0;
			for (int i = start; i < end; i++) 
			{
				physicalMemory[i] = pageId;
				j++;
				if (j == 4) 
				{
					j = 0;
					pageNum++;
				}
			}
		}
		return found;
	}
	
	public static void releasePhysical(Process pr) {
		int pid = pr.getPid();
		for (int memoryPointer = 0; memoryPointer < physicalMemory.length; memoryPointer++) 
		{
			if (physicalMemory[memoryPointer] == pid) {
				physicalMemory[memoryPointer] = 0;
			}
		}
		
	}
	
	public static void usePage(Process pr) {
		int amountOfMemory = pr.getMemReq();
		int initPageNum = pages.size();
		int pagesNeeded = amountOfMemory / 4;
			int id = pr.getPid();
		for (int i=0; i < pagesNeeded; i++) { //adds pages with pid of process
			
			pages.add(id);
		}
		usePhysical(pr, initPageNum);
	}

		
	public static void releasePage(Process pr) {
			pages.remove(pr.getPid());
			releasePhysical(pr);
	}

	
	public static NUMANode correctNode (Process pr, NUMANode numNode1, NUMANode y) 
	{
		NUMANode winner = null;

		if(numNode1.canFit(pr.getMemReq()))
		{
			winner = numNode1;
		}
		else
		{
			winner = y;
		}			
		return winner;
	}

	
	public int decrementMemory(Process newProcess) {
		//n = needed memory
		spaceAvail = spaceAvail - newProcess.getMemReq();
		return spaceAvail;
	}
	
	public int reallocateMemory(Process newProcess) 
	{
		if(newProcess.getCondition() == Condition.TERMINATED || newProcess.getCondition() == Condition.WAITING)
		{
			spaceAvail = spaceAvail + newProcess.getMemReq();
			return spaceAvail;
		}
		else{
			return spaceAvail;
		}
	}
	
	
	
}


