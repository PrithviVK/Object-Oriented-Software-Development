package edu.umb.cs681.hw13;

import java.nio.file.Path;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.List;

public class RequestHandler implements Runnable {
    private final Random random = new Random();
    private final Path[] files = { Path.of("note1.txt"), Path.of("note2.txt"), Path.of("note3.txt") };
    private final Lock lock = new ReentrantLock();
    private volatile boolean done=false;

    public void run() {
        while (true) {
        	if(done) {
        		System.out.println("Terminating...");
				break;
        	}
            Path file = files[random.nextInt(files.length)];
            AccessCounter counter = AccessCounter.getInstance();
            counter.increment(file);
            System.out.println("File " + file + " count: " + counter.getCount(file));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + Thread.currentThread().getName());
//                return;
            }
        }
    }

    public void setDone() {
        lock.lock();
        try {
            done = true;
        } finally {
            lock.unlock();
        }
    }

    
    public static void main(String[] args) throws InterruptedException {
        List<RequestHandler> handlers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            RequestHandler handler = new RequestHandler();
            handlers.add(handler);
            Thread thread = new Thread(handler);
            threads.add(thread);
            thread.start();
        }

        Thread.sleep(5000);

        for (RequestHandler handler : handlers) {
            handler.setDone();
        }

        for (Thread thread : threads) {
                thread.interrupt();
        }
    }
    
    
}
