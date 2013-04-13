public class Decrementer extends Thread {

    private Counter c;
    private int myname;
    private int cycles;

    public Decrementer( Counter count, int name, int quantity ) {
        c = count;
        myname = name;
        cycles = quantity;
    }
    
    public void run() {
        for (int i = 1; i < cycles; i++) {
            c.decrement();
            try {
                sleep( (int) ( Math.random() * 20 ) );
            } catch ( InterruptedException e ) { }
        }
        System.out.println( "Thread #" + myname + " has done " + cycles + " decrements " );
        
        // Only for 6AB
        c.l.countDown();
    }
    
}