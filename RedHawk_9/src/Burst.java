public class Burst 
{
	BurstType bt;
	int preCST;
	int criticalSection;
	int postCST;
	public Burst(BurstType type, int preCSTime, int cs, int postCSTime)
	{
		bt = type;
		preCST = preCSTime;
		criticalSection = cs;
		postCST = postCSTime;
	}
}
