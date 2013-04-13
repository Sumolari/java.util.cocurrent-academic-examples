import java.util.concurrent.atomic.*;

public class DecrementerB extends Thread {

    private AtomicInteger c;
    private int myname;
    private int cycles;
    
    public DecrementerB( AtomicInteger count, int name, int quantity ) {
        c = count; 
        myname = name;
        cycles = quantity;
    }
    
    public void run() {
        for ( int i = 1; i < cycles; i++ ) {
            c.getAndDecrement();
            try {
                sleep( (int) ( Math.random() * 10 ) );
            } catch ( InterruptedException e ) { }
        }
        
        System.out.println("Thread #" + myname + " has done " + cycles + " decrements" );
        
        // For 6BB
        RaceCondition6BB.l.countDown();
    }
    
}