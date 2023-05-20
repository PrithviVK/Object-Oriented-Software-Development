package edu.umb.cs681.primes.Part1;
import java.util.concurrent.locks.*;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator implements Runnable{
	
	public RunnableCancellablePrimeGenerator(long from, long to) {
		super(from, to);
		// TODO Auto-generated constructor stub
	}

	private final ReentrantLock lock = new ReentrantLock();
//	lock.lock();
	private boolean done=false;
//	lock.unlock();
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		}
		finally {
			lock.unlock();
		}
		
	}
	
	public void generatePrimes() {
		for(long n = from; n <= to; n++){
		    lock.lock();
			try{
				if(done) {
					System.out.println("Stopped generating prime numbers.");
					this.primes.clear();
					break;
				}
				if(isPrime(n)) {
					this.primes.add(n);
				}
			}
			finally{ 
				lock.unlock();
				}

		}
	}
	
	public void run() {
		generatePrimes();
	}
	
	
	public static void main(String[] args) {
		RunnableCancellablePrimeGenerator gen = new RunnableCancellablePrimeGenerator(3,100);
		Thread thread = new Thread(gen);
		thread.start();
		gen.setDone();
//		gen.setDone();
		try {
			thread.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		gen.getPrimes().forEach( (Long prime)-> System.out.print(prime + ", ") );
		System.out.println("\n" + gen.getPrimes().size() + " prime numbers are found.");
	}
	
	
}







