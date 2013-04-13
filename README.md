# java.util.cocurrent academic examples

These are just some academic examples of java.util.concurrent library usage.

## SynchronousLink

This example shows how to send a string from a thread to other thread using a shared object as storage.

The point of this example is preventing race conditions and ensuring conditional synchronization.

Uses only ```synchronized``` methods, ```wait``` and ```join```.