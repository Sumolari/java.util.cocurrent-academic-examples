import java.util.concurrent.locks.*;

public class Crosswalk
{

    private int c, c_waiting, p, p_waiting;
    private Condition OKCars, OKPedestrians;
    private ReentrantLock lock;
    
    public static void main( String[] args ) {
    
        Crosswalk c = new Crosswalk();
        
        for ( int i = 0; i < 10; i++ ) {
            Thread t = new Car( c );
            t.start();
            t = new Pedestrian( c );
            t.start();
        }
        
    }

    public Crosswalk()
    {
        c = c_waiting = p = p_waiting = 0;
        lock = new ReentrantLock();
        OKCars = lock.newCondition();
        OKPedestrians = lock.newCondition();
    }

    public void enterC() {
    
        // close lock
        lock.lock();
        
        c_waiting++;
        while ( p > 0 )
            // wait for cars
            try { OKCars.await(); } catch ( Exception e ) { }
            
        c_waiting--;
        c++;
        
        System.out.println( "Enter car" );
        
        // Nofity that cars can now cross
        OKCars.signal();
        
        // open lock
        lock.unlock();
    
    }
    
    public void leaveC() {
    
        // close lock
        lock.lock();
        
        c--;
        
        System.out.println( "Leave car" );
        
        // nofity that cars can now cross
        OKCars.signal();
        
        // notify that pedestrians can now cross
        OKPedestrians.signal();
        
        // open lock
        lock.unlock();
    }
    
    public void enterP() {
    
        // close lock
        lock.lock();
        
        p_waiting++;
        while ( ( c > 0 ) || ( c_waiting > 0 ) )
            // wait for pedestrians can cross
            try { OKPedestrians.await(); } catch ( Exception e ) { }
            
        p_waiting--;
        p++;
        
        System.out.println( "Enter pedestrian" );
        
        // notify that pedestrians can now cross
        OKPedestrians.signal();
        
        // open lock
        lock.unlock();
    }
    
    public void leaveP() {
    
        // close lock
        lock.lock();
        
        p--;
        
        System.out.println( "Leave pedestrian" );
        
        // notify that cars can now cross
        OKCars.signal();
        
        // notify that pedestrians can now cross
        OKPedestrians.signal();
        
        // open lock
        lock.unlock();
        
    }
    
}
