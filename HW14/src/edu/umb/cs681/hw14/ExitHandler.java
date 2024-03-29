package edu.umb.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;

public class ExitHandler implements Runnable {
	private AdmissionMonitor monitor;
	private volatile boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	
	public ExitHandler(AdmissionMonitor monitor) {
		this.monitor=monitor;
	}

	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}

	public void run() {
		while (true) {
			if (done) {
				System.out.println("Terminating...");
				break;
			}
			monitor.exit();
		}
		

	}

}
