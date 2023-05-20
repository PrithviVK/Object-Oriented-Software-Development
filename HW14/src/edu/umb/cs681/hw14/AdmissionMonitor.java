package edu.umb.cs681.hw14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AdmissionMonitor {
//	ReadWriteLock lock = new ReentrantReadWriteLock();

//	Condition condition = readLock.newCondition();
//	Lock readLock = lock.readLock();
	private int currentVisitors = 0;
	private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//	private final Lock readLock = lock.readLock();
//	Condition condition1 = readLock.newCondition();
	private final Lock writeLock = lock.writeLock();
	Condition condition2 = writeLock.newCondition();
	Condition condition3 = writeLock.newCondition();

//	private final Condition condition = lock.newCondition();

	public void enter() {
		lock.writeLock().lock();
		try {
			while (currentVisitors > 10) {
				System.out.println("Too many visitors. Please wait...");
				try {
					condition2.await();
				} catch (InterruptedException e) {
					System.out.println(e.toString());
				}
			}

			System.out.println("Current visitors increasing:"+currentVisitors++);
			
//			condition3.signalAll();
		} finally {
			lock.writeLock().unlock();
		}
	}

	public void exit() {
		//System.out.println("Entering exit()");
		lock.writeLock().lock();
		try {
//			while (currentVisitors < 0) {
//				System.out.println("No visitors currently");
//				try {
//					condition3.await();
//				} catch (InterruptedException e) {
//					System.out.println(e.toString()); 
//				}
//			}
			System.out.println("Current visitors reducing:"+currentVisitors--);
			condition2.signalAll();
		} finally {
			lock.writeLock().unlock();
		}
	}

	public int countCurrentVisitors() {
		lock.readLock().lock();
		try {
			return currentVisitors;
		} finally {
			lock.readLock().unlock();
		}
	}
}
