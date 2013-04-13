public class Pedestrian extends Thread
{
    private Crosswalk c;
    
    public Pedestrian( Crosswalk c ) { this. c = c; }

    public void run() {
    
        c.enterP();
        
        try { sleep( (int) Math.random() * 100 ); } catch ( Exception e ) { }
        
        c.leaveP();
    
    }
}
