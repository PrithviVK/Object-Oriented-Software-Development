package edu.umb.cs681.hw14;

public class Client {
	public static void main(String[] args) {
		
		AdmissionMonitor hand=new AdmissionMonitor();
		EntranceHandler entr=new EntranceHandler(hand);
		ExitHandler exit=new ExitHandler(hand);
		StatsHandler stat=new StatsHandler(hand);
		
		Thread t1=new Thread(entr);
		Thread t2=new Thread(exit);
		Thread t3=new Thread(stat);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		
		entr.setDone();
		exit.setDone();
		stat.setDone();
		
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
		
	}
	
}

