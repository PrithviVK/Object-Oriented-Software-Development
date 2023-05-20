package edu.umb.cs681.hw17.original;

public class AccelerateRunnable implements Runnable {
	private volatile boolean done = false;
	private RemoteCar remotecar;

	public AccelerateRunnable(RemoteCar2 remotecar) {
		this.remotecar = remotecar;
	}
	// Set the done flag to true, indicating the thread should terminate
	public void setDone() {
		done = true;

	}
	// Run method required by the Runnable interface
	public void run() {
		for (int i = 0; i < 10; i++) {
			// Check if the thread is done and terminate if true
			if (done) {
				System.out.println("Terminating...");
				break;
			}
			System.out.println("Accelerating Speed...");
			remotecar.accelerate(10);//accelerate the remote control car

		}

	}

}
