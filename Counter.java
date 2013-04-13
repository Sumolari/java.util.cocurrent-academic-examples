import java.util.concurrent.*;

public class Counter
{
    private int c = 0;
    
    /* Only for 6AB */
    public CountDownLatch l = new CountDownLatch( 2 );
    
    public synchronized void increment() {
        c++;
    }
    
    public synchronized void decrement() {
        c--;
    }
    
    public int value() { 
        return c;
    }
}
