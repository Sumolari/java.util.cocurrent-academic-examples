import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

public class RaceCondition6BB {

    public static CountDownLatch l = new CountDownLatch( 2 );

    public static void main(String[] args) {
        
        AtomicInteger c = new AtomicInteger();
        int loops = 1000;
        System.out.println( "Loops "+ loops );
        
        IncrementerB inc = new IncrementerB( c, 1, loops );
        DecrementerB dec = new DecrementerB( c, 2, loops );
        
        inc.start();
        dec.start();
        
        try { l.await(); } catch ( Exception e ) { }
        
        System.out.println( "Main Thread obtains: " + c.get() );
    
    }

}