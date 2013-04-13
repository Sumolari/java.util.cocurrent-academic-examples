import java.util.concurrent.atomic.*;

public class RaceCondition5B {

    public static void main(String[] args) {
        
        AtomicInteger c = new AtomicInteger();
        int loops = 1000;
        System.out.println( "Loops "+ loops );
        
        IncrementerB inc = new IncrementerB( c, 1, loops );
        DecrementerB dec = new DecrementerB( c, 2, loops );
        
        inc.start();
        dec.start();
        
        try { inc.join(); } catch ( Exception e ) { }
        try { dec.join(); } catch ( Exception e ) { }
        
        System.out.println( "Main Thread obtains: " + c.get() );
    
    }

}