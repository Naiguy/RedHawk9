public class Burst 
{
	BurstType bt;
	int preCST;
	int criticalSection;
	int postCST;
	int totalTime;
	public Burst(BurstType type, int preCSTime, int cs, int postCSTime)
	{
		bt = type;
		preCST = preCSTime;
		criticalSection = cs;
		postCST = postCSTime;
		totalTime = preCSTime + cs + postCSTime;	
	}
	public Burst(BurstType type, int time)
	{
		bt = type;
		totalTime = time;
	}
}