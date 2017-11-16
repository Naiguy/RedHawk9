public class Burst 
{
	BurstType bt;
	int preCST;
	int criticalSection;
	int postCST;
	int totalTime;
	String data;
	public Burst(BurstType type, int preCSTime, int cs, int postCSTime, String d)
	{
		bt = type;
		preCST = preCSTime;
		criticalSection = cs;
		postCST = postCSTime;
		totalTime = preCSTime + cs + postCSTime;	
		data = d;
	}
	/*
	public Burst(BurstType type, int time)
	{
		bt = type;
		totalTime = time;
	}
	*/
}