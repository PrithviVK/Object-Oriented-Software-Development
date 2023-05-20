package edu.umb.cs681.hw17.revised;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class RemoteCar2 implements RemoteCar {
	private int currentSpeed = 0;// The current speed of the remote car
	private ReentrantLock lock = new ReentrantLock();// A lock for thread synchronization
	private Condition speedExceedCondition = lock.newCondition();// Condition variable for speed exceeding max speed
	private Condition invalidSpeedCondition = lock.newCondition();// Condition variable for invalid speed

	@Override
	public void accelerate(int speed) {// accelerating remote control car
		lock.lock();
		try {
			System.out.println("Lock obtained");
			System.out.println(Thread.currentThread().getId() + " (a): current speed: " + currentSpeed);
			// Check if the speed exceeds the maximum allowed speed (200)
			while (speed >= 20) {
				System.out.println(Thread.currentThread().getId() + " (a): await(): speed exceeds max speed.");
				try {
					invalidSpeedCondition.await();// Wait until the speed is valid
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			// Update the current speed and print the updated speed
			currentSpeed += speed;
			System.out.println(Thread.currentThread().getId() + "(a) updated speed: " + currentSpeed);
			speedExceedCondition.signalAll();// Signal threads waiting on the speedExceedCondition
		} finally {
			lock.unlock();// Release the lock
			System.out.println("Lock released");
		}

	}

	@Override
	public void decelerate(int speed) {// Implementing the decelerate method

		lock.lock();
		try {
			System.out.println("Lock obtained");
			System.out.println(Thread.currentThread().getId() + " (d): current speed: " + currentSpeed);
			while (speed <= 0) {// Check if the speed is invalid (<= 0)
				System.out.println(Thread.currentThread().getId() + " (d): await(): Invalid Speed");
				try {
					speedExceedCondition.await();// Wait until the speed is valid
				} catch (InterruptedException e) {
//					return;
					e.printStackTrace();
				}
			}
			currentSpeed -= speed;// Update the current speed and print the updated speed
			System.out.println(Thread.currentThread().getId() + " (d): updated speed: " + currentSpeed);
			invalidSpeedCondition.signalAll();// Signal threads waiting on the invalidSpeedCondition

		} finally {
			lock.unlock();
			System.out.println("Lock released");
		}

	}

	@Override
	public double getSpeed() {// Implementing the getSpeed method
		return this.currentSpeed;
	}

}
