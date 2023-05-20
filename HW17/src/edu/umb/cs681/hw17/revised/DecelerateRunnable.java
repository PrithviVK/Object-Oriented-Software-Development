package edu.umb.cs681.hw17.revised;

import java.util.concurrent.locks.ReentrantLock;

public class DecelerateRunnable implements Runnable {
	private volatile boolean done = false;// A volatile boolean flag to indicate if the task is done
	private RemoteCar remotecar;// A reference to a RemoteCar object
	private ReentrantLock lock = new ReentrantLock(); // A lock for thread synchronization
	
	// Constructor that takes a RemoteCar object
	public DecelerateRunnable(RemoteCar2 remotecar) {
		this.remotecar = remotecar;
	}

	public void setDone() {
		lock.lock();// Acquire the lock to ensure atomicity
		try {
			done = true;
		} finally {
			lock.unlock();// Release the lock
		}

	}

	public void run() {// Method that will be executed when the thread starts
		for (int i = 0; i < 10; i++) {
			if (done) {// If the done flag is true, terminate the loop
				System.out.println("Terminating...");
				break;
			}
			System.out.println("Decelerating Speed...");
			remotecar.decelerate(10);// Call the decelerate method of the RemoteCar object
		}
	}
}