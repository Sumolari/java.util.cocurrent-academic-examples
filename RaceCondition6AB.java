public class RaceCondition6AB {

    public static void main(String[] args) {
        
        Counter c = new Counter();
        int loops = 1000;
        System.out.println( "Loops "+ loops );
        
        Incrementer inc = new Incrementer( c, 1, loops );
        Decrementer dec = new Decrementer( c, 2, loops );
        
        inc.start();
        dec.start();
        
        try { c.l.await(); } catch ( Exception e ) { }
        
        System.out.println( "Main Thread obtains: " + c.value() );
    
    }

}