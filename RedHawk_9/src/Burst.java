public class Burst 
{
	private BurstType bt;
	private int preCST;
	private int criticalSection;
	private int postCST;
	private int totalTime;
	private String data;
	public Burst(BurstType type, int preCSTime, int cs, int postCSTime, String d)
	{
		setBt(type);
		setPreCST(preCSTime);
		setCriticalSection(cs);
		setPostCST(postCSTime);
		setTotalTime(preCSTime + cs + postCSTime);	
		setData(d);
	}
	public BurstType getBt() {
		return bt;
	}
	public void setBt(BurstType bt) {
		this.bt = bt;
	}
	public int getPreCST() {
		return preCST;
	}
	public void setPreCST(int preCST) {
		this.preCST = preCST;
	}
	public int getCriticalSection() {
		return criticalSection;
	}
	public void setCriticalSection(int criticalSection) {
		this.criticalSection = criticalSection;
	}
	public int getPostCST() {
		return postCST;
	}
	public void setPostCST(int postCST) {
		this.postCST = postCST;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	/*
	public Burst(BurstType type, int time)
	{
		bt = type;
		totalTime = time;
	}
	*/
}