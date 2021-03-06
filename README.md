These are just some academic examples of java.util.concurrent library usage.

## SynchronousLink

This example shows how to send a string from a thread to other thread using a shared object as storage.

The point of this example is preventing race conditions and ensuring conditional synchronization.

Uses only ```synchronized``` methods, ```wait```, ```notify``` and ```join```.

## RaceCondition

This example shows how to solve the producer-consumer problem. 

In an only-one-space buffer a consumer thread try to put some values and a consumer thread tries to read some values. The value should not be read when buffer is empty and no value should be put when buffer is full.

It is similar to [SynchronousLink][1], the difference is that there are only two threads and each one performs its action more than once.

The point of this example is preventing race conditions and ensuring 
conditional synchronization.

Uses only ```synchronized``` methods, ```wait``` and ```notify```.

## Crosswalk

This example shows how to solve the crosswalk problem.

In a crosswalk where only can cross either cars or pedestrians but not both, there are some pedestrian threads and car threads. Any thread can try to cross the crosswalk while there might be other threads crossing it.

When there are cars crossing the crosswalk only cars can enter in the crosswalk. When there are pedestrians crossing the crosswalk cars cannot enter in. Cars have priority so pedestrians cannot enter in the crosswalk if there are cars waiting to enter.

The point of this example is ensuring conditional synchronization.

Uses ```ReentrantLock``` and ```Condition``` variables.

## RaceCondition

This example shows how to prevent race conditions and waiting threads using different approaches.

Having two threads, one which increases the value and one which decreases the value of a shared variable, and increasing/decreasing the same amount, final value of variable should be the initial one (```0```) and should be printed at the end by the main thread.

### RaceCondition5A

Solves problem using a monitor and joining threads.

Uses only ```synchronized``` methods and ```join```.

### RaceCondition 6AB

Solves problem using a monitor and a CountDownLatch.

Uses ```synchronized``` methods and ```CountDownLatch```.

### RaceCondition5B

Solves problem using an atomic variable and joining threads.

Uses ```AtomicInteger``` and ```join```.

### RaceCondition6BB

Solves problem using an atomic variable and a CountDownLatch.

Uses ```AtomicInteger``` and ```CountDownLatch```.

[1]: #synchronouslink "Synchronous Link"