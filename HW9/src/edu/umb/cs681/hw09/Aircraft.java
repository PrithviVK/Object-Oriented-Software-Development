package edu.umb.cs681.hw09;
import java.util.concurrent.locks.ReentrantLock;


public final class Aircraft {
	private Position position; 
	private final ReentrantLock lock;
	
	public Aircraft(Position pos){ 
		this.lock = new ReentrantLock();
		this.position = pos;
		
	}
	
	public void setPosition(double newLat, double newLong,double newAlt){
		lock.lock();
		try {
			this.position = this.position.change(newLat, newLong, newAlt);
			}
		
		finally {
			lock.unlock();
		}
	}
	
	  
	public Position getPosition(){ 
		lock.lock();
		try {
			return position;
		}
		
		finally {
			lock.unlock();
		}
	}
	


}