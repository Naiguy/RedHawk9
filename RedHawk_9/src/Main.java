import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Calendar a = Calendar.getInstance();

            

            String sec = Integer.toString(a.get(Calendar.SECOND));
            String min = Integer.toString(a.get(Calendar.MINUTE));
            String hour = Integer.toString(a.get(Calendar.HOUR_OF_DAY));
            String mili = Integer.toString(a.get(Calendar.MILLISECOND));
           
            String time = hour + ":" + min + ":" + sec + ":" + mili;

            System.out.println(time);
            
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}