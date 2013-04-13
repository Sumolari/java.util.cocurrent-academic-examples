public class Sender extends Thread
{
    SynchronousLink sl;
    int id;
    
    public Sender ( SynchronousLink sl, int id ) { this.sl = sl; this.id = id; }
    
    public void run() {
    
        sl.send( "Message from sender #" + id );
        
    }
    
}
