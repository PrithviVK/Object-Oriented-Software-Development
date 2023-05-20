package edu.umb.cs681.hw17.revised;


public class Client {
	public static void main(String[] args) {
		RemoteCar2 remotecar = new RemoteCar2();
		AccelerateRunnable d1 = new AccelerateRunnable(remotecar);// Create an AccelerateRunnable with remotecar
		DecelerateRunnable w1 = new DecelerateRunnable(remotecar);// Create a DecelerateRunnable with remotecar
		AccelerateRunnable d2 = new AccelerateRunnable(remotecar);// Create another AccelerateRunnable with remotecar
		DecelerateRunnable w2 = new DecelerateRunnable(remotecar);// Create another DecelerateRunnable with remotecar

		Thread dt1 = new Thread(d1);
		Thread dt2 = new Thread(d2);
		Thread wt1 = new Thread(w1);
		Thread wt2 = new Thread(w2);

		System.out.println("Running threads...");

		dt1.start();
		dt2.start();
		wt1.start();
		wt2.start();

		try {
			Thread.sleep(5000);// Pause the main thread for 5 seconds
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}

		d1.setDone();// Signal d1 to finish execution
		d2.setDone();// Signal d2 to finish execution
		w1.setDone();// Signal w1 to finish execution
		w2.setDone();// Signal w2 to finish execution

		dt1.interrupt();// Interrupt the thread for d1
		dt2.interrupt();// Interrupt the thread for d2
		wt1.interrupt();// Interrupt the thread for w1
		wt2.interrupt();// Interrupt the thread for w2
	}
}
