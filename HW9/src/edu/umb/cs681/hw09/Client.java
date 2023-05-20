package edu.umb.cs681.hw09;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
	private static ReentrantLock lock = new ReentrantLock();
	public static void main(String[] args) {
			Runnable obj= ()-> {lock.lock();
				Position position=new Position(46,-120,200);
				Aircraft aircraft=new Aircraft(position);
				Position old=aircraft.getPosition();
				
//				double newLat=old.latitude()+10;
//				double newLong=old.longitude()+10;
//				double newAlt=old.altitude()+10;
				System.out.println("Old Position is:"+old.toString());
				
//				Position newPosition = new Position(old.latitude() + 1, old.longitude() + 1, old.altitude() + 1);
				System.out.println("Updating position of aircraft : "+ Thread.currentThread().getId());
				aircraft.setPosition(aircraft.getPosition().latitude()+10,aircraft.getPosition().longitude()+10,aircraft.getPosition().altitude()+10);
				System.out.println("Updated position is:"+aircraft.getPosition().toString());
				lock.unlock();
			};
			
			Thread t1=new Thread(obj);//multiple threads running the same instance it is thread safe
			Thread t2=new Thread(obj);
			Thread t3=new Thread(obj);
			
			t1.start();
//			try {
//				t1.sleep(1000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			t2.start();
			t3.start();
//			try {
//				t2.sleep(1000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
//			try {
//				t1.join();
//				t2.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		
			
	}
}
