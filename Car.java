public class Car extends Thread
{
    private Crosswalk c;
    
    public Car( Crosswalk c ) { this. c = c; }

    public void run() {
    
        c.enterC();
        
        try { sleep( (int) Math.random() * 100 ); } catch ( Exception e ) { }
        
        c.leaveC();
    
    }
}
