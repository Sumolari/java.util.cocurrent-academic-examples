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

[1]: #synchronouslink "Synchronous Link"