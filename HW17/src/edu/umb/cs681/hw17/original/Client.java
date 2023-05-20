package edu.umb.cs681.hw17.original;

public class Client {
	public static void main(String[] args) {
		RemoteCar2 remotecar = new RemoteCar2();
		AccelerateRunnable d1 = new AccelerateRunnable(remotecar);
		DecelerateRunnable w1 = new DecelerateRunnable(remotecar);
		AccelerateRunnable d2 = new AccelerateRunnable(remotecar);
		DecelerateRunnable w2 = new DecelerateRunnable(remotecar);

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
			Thread.sleep(5000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}

		d1.setDone();
		d2.setDone();
		w1.setDone();
		w2.setDone();

		dt1.interrupt();
		dt2.interrupt();
		wt1.interrupt();
		wt2.interrupt();
		
		

	}

}
