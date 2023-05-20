package edu.umb.cs681.hw17.original;

public class RemoteCar2 implements RemoteCar {
	private int currentSpeed = 0;

	// Accelerate method implementation
	@Override
	public void accelerate(int speed) {

		// Print current thread ID and current speed
		System.out.println(Thread.currentThread().getId() + " (a): current speed: " + currentSpeed);
		// Loop while speed is greater than or equal to 200
		while (speed >= 200) {
			System.out.println(Thread.currentThread().getId() + " (a): await(): speed exceeds max speed.");
		}

		currentSpeed += speed;
		System.out.println(Thread.currentThread().getId() + "(a) updated speed: " + currentSpeed);

	}

	@Override
	public void decelerate(int speed) {

		System.out.println(Thread.currentThread().getId() + " (d): current speed: " + currentSpeed);
		// Loop while speed is less than or equal to 0
		while (speed <= 0) {
			System.out.println(Thread.currentThread().getId() + " (d): await(): Invalid Speed");
		}

		currentSpeed -= speed;
		System.out.println(Thread.currentThread().getId() + " (d): updated speed: " + currentSpeed);

	}

	@Override
	public double getSpeed() {
		return this.currentSpeed;
	}

}
