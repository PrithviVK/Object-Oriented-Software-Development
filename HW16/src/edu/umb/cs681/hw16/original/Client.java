package edu.umb.cs681.hw16.original;

import java.util.ArrayList;
import java.util.List;

public class Client {
	 public static void main(String[] args) throws InterruptedException {
	        List<RequestHandler> handlers = new ArrayList<>();
	        List<Thread> threads = new ArrayList<>();
	     // Create and start multiple RequestHandler threads
	        for (int i = 0; i < 10; i++) {
	            RequestHandler handler = new RequestHandler();
	            handlers.add(handler);
	            Thread thread = new Thread(handler);
	            threads.add(thread);
	            thread.start();
	        }
	     // Wait for 5000 milliseconds (5 seconds)
	        Thread.sleep(5000);
	     // Set the done flag for all RequestHandlers to terminate the threads
	        for (RequestHandler handler : handlers) {
	            handler.setDone();
	        }
	     // Interrupt each thread and wait for them to finish with a timeout of 1000 milliseconds (1 second)
	        for (Thread thread : threads) {
	                thread.interrupt();
//	                thread.join(1000);

	        }
	    }

}
