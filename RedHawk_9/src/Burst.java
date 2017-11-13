public class Burst 
{
	BurstType bt;
	int preCST;
	boolean criticalSection;
	int postCST;
	public Burst(BurstType type, int preCSTime, boolean cs, int postCSTime)
	{
		bt = type;
		preCST = preCSTime;
		criticalSection = cs;
		postCST = postCSTime;
	}
}
