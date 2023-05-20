HW17

Remote Control Car

The assignment focuses on accelerating and decelerating of a remote control car that makes use of accelerate method to accelerate
the car to move forward and decelerate to reduce it's speed and halt. We call accelerate() and decelerate() to 
increment the speed not more than 20 and decrement the speed and finally stop if the speed is lesser than 0. However, the 
car keeps decelerating and goes below zero since threads go into a deadlock. To overcome this problem I've implemented locks
and have used the .await() and .signalAll() methods in while loop to signal other threads when the current thread has gone to
the wait state. Therefore, the problem of deadlock is overcome by taking into consideration the constraints thereby 
making the threads work in synchronization.

