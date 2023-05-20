package edu.umb.cs681.hw19;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;


public class StockQuoteObservable extends Observable<StockEvent> {
	
	HashMap<String,Integer> map = new HashMap<>(); 
	private ReentrantLock lock = new ReentrantLock();

	public void changeQuote(String t,Integer q) {
			
			map.put(t, q);
			notifyObservers(new StockEvent(t,q));
		
		}
		

	@Override
	public void update(Observable sender, StockEvent event) {
		// TODO Auto-generated method stub
		
	}
}