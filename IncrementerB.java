import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

public class IncrementerB extends Thread {

    private AtomicInteger c;
    private int myname;
    private int cycles;
    
    public IncrementerB( AtomicInteger count, int name, int quantity ) {
        c = count; 
        myname = name;
        cycles = quantity;
    }
    
    public void run() {
        for ( int i = 1; i < cycles; i++ ) {
            c.getAndIncrement();
            try {
                sleep( (int) ( Math.random() * 10 ) );
            } catch ( InterruptedException e ) { }
        }
        
        System.out.println("Thread #" + myname + " has done " + cycles + " increments" );
        
        // For 6BB
        RaceCondition6BB.l.countDown();
    }
    
}