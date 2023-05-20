package edu.umb.cs681.hw19;

import java.util.ArrayList;
import java.util.List;

public class Client extends Observable implements java.lang.Runnable{
	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();
		List<Client> handlers = new ArrayList<>();

		for (int i = 0; i < 12; i++) {
			Client handler = new Client();
			handlers.add(handler);
			Thread thread = new Thread(handler);
			threads.add(thread);
			thread.start();
			System.out.println("Running Thread:" + thread.getName());
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (Client handler : handlers) {
			handler.setDone();
		}

		for (Thread thread : threads) {
			thread.interrupt();
		}

	}


	@Override
	public void update(Observable sender, StockEvent event) {
		// TODO Auto-generated method stub
		
	}

}

