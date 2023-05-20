package edu.umb.cs681.primes.Part2;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer implements Runnable {
	
	public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
		super(dividend, from, to);
	}

	private boolean done=false;
	private final ReentrantLock lock = new ReentrantLock();
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		}
		finally {
			lock.unlock();
		}
	}
	
	
	public void generatePrimeFactors() {
		long divisor = from;
	    while( dividend != 1 && divisor <= to ){
	    	lock.lock();
	    	try {
	    	if(done) {
	    		System.out.println("Stopped generating prime numbers.");
				this.factors.clear();
				break;
				}
	    	if( divisor > 2 && isEven(divisor)) {
	    		divisor++;
	    		continue;
	    		}
		    if(dividend % divisor == 0) {
		        factors.add(divisor);
		        dividend /= divisor;
		    	}
		    else {
		    	if(divisor==2){ divisor++; }
		    	else{ divisor += 2; }
		    	}
		    }
	    	finally {
	    		lock.unlock();
	    	}
		}
	}
	
	public void run() {
		generatePrimeFactors();
	}
	
	
	
	public static void main(String[] args) {
		RunnableCancellablePrimeFactorizer gen = new RunnableCancellablePrimeFactorizer(36, 2, (long)Math.sqrt(36));
		Thread thread = new Thread(gen);
		thread.start();
		gen.setDone();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		gen.setDone();
		gen.getPrimeFactors().forEach( (Long prime)-> System.out.print(prime + ", ") );
		System.out.println("\n" + gen.getPrimeFactors().size() + " prime factors are found.");
	}
	
}



















