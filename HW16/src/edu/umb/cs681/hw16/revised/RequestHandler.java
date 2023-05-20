package edu.umb.cs681.hw16.revised;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class RequestHandler implements Runnable {
	private final Random random = new Random();
	private final String[] meters = { "Meter 1", "Meter 2", "Meter 3" };
	private volatile boolean done = false;
	private final Lock lock = new ReentrantLock();
	
	public void run() {
		while (true) {
			// Check if the thread is done and terminate if true
			if (done) {
				System.out.println("Terminating..." + Thread.currentThread().getName());
				break;
			}
			// Select a random meter from the meters array
			String meter = meters[random.nextInt(meters.length)];
			// Get the instance of MeterManager
			MeterManager counter = MeterManager.getInstance();
			// Increment the count for the selected meter
			counter.incrementMeterCount(meter);
			// Print the meter name and its current count
			System.out.println(meter + " value: " + counter.getMeterCount(meter));
		}
	}
	// Set the done flag to true, indicating the thread should terminate
	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}

}
