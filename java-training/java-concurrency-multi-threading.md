Applying Concurrency and Multi-threading to Common Java Patterns
================================================================

What is a thread?
-----------------
 * A thread is defined at the OS level
 * A thread is a set of instructions
 * An application can be composed of several threads
 * Different threads can be executed "at the same time"
 * A thread can be running or not
 * If it not running, can the thread scheduler give it a hand?
  - if it is in the wait list, the answer is no

Scheduler
---------
 * Is responsible for the CPU sharing
 * There are three reasons for the scheduler to pause a thread:
  - the CPU should be shared equally among threads
  - the thread is waiting for some more data
  - the thread is waiting for another thread to do something

Race Condition
--------------
 * Accessing data concurrently may lead to issues
 * It means that two different threads are trying to read and write
the same variable at the same time
 * How to prevent? : Synchronization
  - prevents a block of code to be executed by more 
than one thread at the same time

Synchronization
---------------
 * For synchronization to work, we need a special, technical object
that will hold the key
 * In fact, every Java object can play this role
 * This key is also called a monitor
 * A synchronized static method uses the instance as a synchronization object
 * Synchronization protects a block of code
 * Guarantees this code is executed by one thread at a tim
 * Prevents race condition

Locks and Deadlocks
-------------------
 * Locks are reentrant: when a thread holds a lock, it can enter a block
synchronized on the lock it is holding
 * Deadlock: is a situation where a thread T1 holds a key needed 
by a thread T2, and T2 holds the key needed by T1
 * The JVM is able to detect deadlock situations, and can log information
to help debug the application
 * But there is not much we can do if a deadlock situation occurs, 
besid rebooting the JVM

Runnable Pattern
----------------
 * The most basic way to create threads in Java
 * First create an instance of Runnable
 * Then pass it to the constructor of the Thread class
 * The call the start() method of this thread object
 ```
 Runnable runnable = () -> {
     String name = Thread.currentThread().getName();
     System.out.println("I am running in thread " + name);
 };
 Thread thread = new Thread(runnable);
 thread.start();
 ```
 * A thread executes a task 
 * Runnable Interface has only one method, it is thus functional interface

How to stop a thread?
---------------------
 - More tricky than it seems
 - There is a method in the Thread class called stop()...
but this method should not be used. (Legacy code)
 - The right pattern is to use the interrupt() method
 - The call to interrupt() causes the isInterrupted() method to return true
 - If the thread is blocked, or waiting, then the corresponding method
will throw an InterruptedException
 - The methods wait(), notify(), join() throw InterruptedException

Product/Consumer Pattern
------------------------
 * A producer produces values in a buffer
 * A consumer consumes the values from this buffer
 * Be carefull: the buffer can be empty, or full
 * Producers and consumers are run in their own thread

Wait/Notify Pattern
-------------------
 * wait() and notify() are two methods from the Object class
 * They are invoked on a given object
 * The thread executing the invocation should hold the key of that object
 * So: wait() and notify() cannot be invoked outside a synchronized code
 * Calling wait()
  - realeases the key held by this thread
  - and puts that thread in a *wait* state
  - the only way to release a thread from a *wait* state is to notify
 * Calling notify()
  - releases a thread in *wait* state and puts it in *runnable* state
  - this is the only way to release a waiting thread
  - there is also a notifyAll() method

States of a Thread
------------------
 * New
  - Runnable
   - Blocked: waiting at the entrance of a synchronized block
   - Waiting: parked using a wait() call
   - Timed Waiting: parked using a sleep(timeout) or wait(timeout) call
  - Terminated
 * The thread scheduler can run the threads in the state *runnable*
 * A *blocked* thread can only run again when the key is released
 * A *waiting* thread can only run again when the *notify()* method is called
 * The *getState()* method returns a enumerated value of type Thread.State

Visibility
----------
 * A variable is said visible
 * If the writes made on it are visible
 * All the synchronized writes are visible
 * Guarantees the consistency of the variables

The Java Memory Model
---------------------
 * Multicore CPU brings new problems
 * Read and writes can really happen at the same time
 * A given variable can be stored in more than on place
 * Visibility means "a read should return the value set by the last write"
 * What does last mean in a multicore world?
  - T1 writes 1 to x
  - T2 reads x and copy it to r
  - What is the value of r?
    - if there is no "happens before" link between the two operations,
    the value of r is unknown
    - if the is "happens before" link, the value of r is 1

Happens before link
-------------------
 * A "happens before" link exists between all synchronized or volative write
operations and all synchronized or volatile read operations that follow
 * All shared variables should be accessed in a synchronized or a volatile way

False Sharing
-------------
 * False sharing happens because of the way the CPU caches work
 * It is a side effect, that can have a tremendous effect on performance
 * The cache is organized in lines of data
 * Each line can hold 8 longs (64bytes)
 * When a visible variable is modified in an L1 cache, all the line is marked
as "dirty" for the other caches
 * A read on a dirty line triggers a refresh on this line

Singleton Pattern
-----------------
 * Should have only one instance
 * Tricky to write in a concurrent environment
 * The basic implementation is not thread safe
 * 1st solution: synchronized
  - since the read is synchronized, it cannot be made in parallel
  - once instance has been initialized, we want to be able to allow its reading in parallel
  - not a good solution for multi core CPUs
 * 2nd solution: double check locking
  - unsynchronized read and synchronized write
  - but we don't have the guarantee that the read will get the value
set by the write because there is no "happens before" link leading to
a buggy solution
  - this bug is a concurrent but, cannot be observed on a single core CPU
  - the effect can be very weird: one can observe an object that is not fully built
 * 3rd solution: Enumeration

How to write correct concurrent code?
-------------------------------------
 * Check for race conditions
  - they occur on fields (not variables/parameters)
  - more than on thread are reading/writing a given field
 * Check for the happens-before link
  - are the read/write volatile?
  - are they synchronized?
  - if not, there is a probably bug
 * Synchronized or volatile?
  - Synchronized = atomicity
  - Volatile = visibility