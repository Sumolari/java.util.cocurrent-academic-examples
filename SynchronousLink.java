public class SynchronousLink
{

    int senders_waiting, receivers_waiting;
    String msg;
    
    public static void main( String[] args ) {
    
        SynchronousLink sl = new SynchronousLink();
        
        Thread ts[] = new Thread[20];
        
        for ( int i = 0; i < 10; i++ ) {
            Thread t = new Sender( sl, i );
            ts[i] = t;
            t.start();
        }
        
        for ( int i = 0; i < 10; i++ ) {
            Thread t = new Reader( sl );
            ts[10+i] = t;
            t.start();
        }
        
        for ( Thread t : ts ) 
            try { t.join(); } catch ( Exception e ) { }

            
        System.out.println("===============");
    }
    
    public SynchronousLink() {
        senders_waiting = receivers_waiting = 0;
        msg = null;
    }
    
    public synchronized void send( String m ) {
       
        while ( msg != null ) { 
            senders_waiting++;
            try { wait(); } catch ( Exception e ) { }
            senders_waiting--;
        }
        
        if ( receivers_waiting > 0 ) {
            notifyAll();
        }
        
        msg = m;
        
    }
    
    public synchronized String receive() {
    
        while ( msg == null ) {
            receivers_waiting++;
            try { wait(); } catch ( Exception e ) { }
            receivers_waiting--;
        }
        
        if ( senders_waiting > 0 ) {
            notifyAll();
        }
        
        String r = msg;
        msg = null;
        
        return r;
        
    }

}
