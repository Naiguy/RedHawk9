
public class Process 
{
    private int pID;
    private int baseCycle; //Starting frame of the process
    private int period; // Ex. Process1 has period of 2 it runs every other two seconds
    private boolean hasCS; // does process has critical section?
    private Burst[] cpuBurst;
    private Burst[] ioBurst;
    private int memReq; // process size MB

    // May need the declarations below later on
    // private static final int sysSpace = 256; // unit: MB
    //private int spaceAvail;

    public void newProc(int pID, boolean hasCS,int memReq, Burst[] cpuBurst, Burst[] ioBurst, int bc, int p) 
    {
        this.pID = pID;
        this.hasCS = hasCS;
        this.memReq = memReq;
        this.cpuBurst = cpuBurst;
        this.ioBurst = ioBurst;
        this.baseCycle = bc;
        this.pID = p;
    }
    
    public int getPid()
    {
        return pID;
    }
    public boolean getCS()
    {
        return hasCS;
    }
    public int getMemReq()
    {
        return memReq;
    }
    public Burst[] getCPUBurst()
    {
        return cpuBurst;
    }
    public Burst[] getIOBurst()
    {
        return ioBurst;
    }
}
