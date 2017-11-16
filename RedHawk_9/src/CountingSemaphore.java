import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class CountingSemaphore 
{
	private static Semaphore countingSem = new Semaphore(1);
	private static ArrayList<Semaphore> semArray = new ArrayList<Semaphore>();
	private static Semaphore countingSem2 = new Semaphore(1);
	private static Semaphore countingSem3= new Semaphore(1);
	private static Semaphore countingSem4 = new Semaphore(1);
	private static Semaphore countingSem5 = new Semaphore(1);
	private static Semaphore countingSem6 = new Semaphore(1);

	public static void main(String args[]) 
	{
		
		final CountingSemaphore test = new CountingSemaphore();
		//test.addSemsToSemArray();
		System.out.println("Number of Semaphores in array " + semArray.size());
        /*
         Thread t1 = new Thread("New Thread") 
        {
        		@Override
            public void run()
            {
              test.mutualExclusion(); 
            }
        };
        t1.setName("New Thread");
        //t1.start();
         */
        test.mutualExclusion();
        new Thread("T3")
        {
            @Override
            public void run()
            {
              test.mutualExclusion(); 
            }
        }.start();
      
        new Thread("T4")
        {
            @Override
            public void run()
            {
              test.mutualExclusion(); 
            }
        }.start();
      
    }
	
	public void addSemsToSemArray()
	{
		semArray.add(countingSem);
		semArray.add(countingSem2);
		semArray.add(countingSem3);
		semArray.add(countingSem4);
		semArray.add(countingSem5);
		semArray.add(countingSem6);


	}
	
    private void mutualExclusion() 
    {
        try 
        {
        	countingSem.acquire();

            //mutual exclusive region
            System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
            Thread.sleep(1000);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } finally {
        	countingSem.release();
            System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
        }
    } 
  
}
	

