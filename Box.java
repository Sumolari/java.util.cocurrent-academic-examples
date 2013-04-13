public class Box
{
    private int content = 0;
    private boolean full = false;
    
    public synchronized int get() {
    
        while ( !full ) try { wait(); } catch ( Exception e ) { }
        int value = content;
        content = 0;
        full = false;
        
        notifyAll();
        
        return value;
        
    }
    
    public synchronized void put( int value ) {
        
        while ( full ) try { wait(); } catch ( Exception e ) { }
        full = true;
        content = value;
        
        notifyAll();
        
    }
}