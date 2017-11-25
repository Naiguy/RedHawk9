public class Burst 
{
	private BurstType bt;
	private int length;
	private String data;
	
	public Burst(BurstType bt, int lengthOfBurst, String s)
	{
		this.bt = bt;
		this.setLength(lengthOfBurst);
		this.data = s;
	}

	public BurstType getBt() 
	{
		return bt;
	}
	public void setBt(BurstType bt) 
	{
		this.bt = bt;
	}

	public String getData()
	{
		return data;
	}
	public void setData(String data) 
	{
		this.data = data;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	/*
	public Burst(BurstType type, int time)
	{
		bt = type;
		totalTime = time;
	}
	*/
}