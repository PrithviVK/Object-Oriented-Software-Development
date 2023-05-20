package edu.umb.cs681.hw17.revised;

import java.util.concurrent.locks.ReentrantLock;

//A volatile boolean flag to indicate if the task is done
public class AccelerateRunnable implements Runnable {
	private volatile boolean done = false;
	// A reference to a RemoteCar object
	private RemoteCar remotecar;
	private ReentrantLock lock = new ReentrantLock();// A lock for thread synchronization

	// Constructor that takes a RemoteCar object
	public AccelerateRunnable(RemoteCar2 remotecar) {
		this.remotecar = remotecar;
	}

		
	// Method to set the done flag to true
	public void setDone() {
		lock.lock();// Acquire the lock to ensure atomicity
		try {
			done = true;
		} finally {
			lock.unlock();// Release the lock
		}

	}

	// Method that will be executed when the thread starts
	public void run() {
		for (int i = 0; i < 10; i++) {
			// If the done flag is true, terminate the loop
			if (done) {
				System.out.println("Terminating...");
				break;
			}
			System.out.println("Accelerating Speed...");
			// Call the accelerate method of the RemoteCar object
			remotecar.accelerate(10);

		}
	}

}
