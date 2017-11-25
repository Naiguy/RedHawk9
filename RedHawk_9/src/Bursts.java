import java.util.ArrayList;

public class Bursts extends ArrayList
{
	@SuppressWarnings("unchecked")
	public Bursts(Object... burst) 
	{
		for (int counter = 0; counter < burst.length; counter+=3) 
		{
			this.add(new Burst(((Character) burst[counter] == 'C') ? BurstType.CPU : BurstType.IO , (((Integer) burst[counter+1])), (String) burst[counter+2]));
		}
	}
}
