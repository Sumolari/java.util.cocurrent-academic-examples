public class Reader extends Thread
{
    SynchronousLink sl;
    
    public Reader ( SynchronousLink sl ) { this.sl = sl; }
    
    public void run() {
    
        System.out.println( sl.receive() );
        
    }
    
}
