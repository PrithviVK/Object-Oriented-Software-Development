package edu.umb.cs681.hw08;

//import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer implements Runnable {
	
	private boolean done = false;
//	private final ReentrantLock lock = new ReentrantLock();
//	private volatile boolean running = true;
	
	public RunnableCancellableInterruptiblePrimeFactorizer(long dividend,long from, long to) {
		super(dividend,from, to);
	}


	public void generatePrimeFactors(){
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
				
				try {
					Thread.sleep(3000);
				}
				
				catch (InterruptedException e) {
					System.out.println(e.toString());
				}
				
				
				
			} 
			

			}
	
//	public void run() {
//		generatePrimeFactors();
//	}
		
	

	public static void main(String[] args) {
		RunnableCancellableInterruptiblePrimeFactorizer gen = new RunnableCancellableInterruptiblePrimeFactorizer(36, 2, (long)Math.sqrt(36));
		Thread thread = new Thread(gen);
		thread.start();

		gen.setDone();
		
		thread.interrupt();
		

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		gen.getPrimeFactors().forEach( (Long prime)-> System.out.print(prime + ", ") );
		System.out.println("\n" + gen.getPrimeFactors().size() + " prime factors are found.");
	}

}









