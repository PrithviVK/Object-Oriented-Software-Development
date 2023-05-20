package edu.umb.cs681.hw15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Observable<T> implements Observer, Runnable {
	private LinkedList<Observer<T>> observers = new LinkedList<>();
	private ReentrantLock lock = new ReentrantLock();
	private volatile boolean done = false;

	public void addObserver(Observer<T> o) {

		observers.add(o);

	}

	public void clearObservers() {
		observers.clear();

	}

	public List<Observer<T>> getObservers() {

		return observers;

	}

	public int countObservers() {

		return observers.size();

	}

	public void removeObserver(Observer<T> o) {

		observers.remove(o);

	}

	public void notifyObservers(StockEvent event) {
		HashSet<Observer> observersLocal;
		lock.lock();
		try {
			observersLocal = new HashSet<Observer>(observers);
		} finally {
			lock.unlock();
		}
		observers.forEach((observer) -> {
			observer.update(this, event);
		});

	}

	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}

	public void Runnable() {
		while (true) {
			lock.lock();
			try {
				if (done) {
					System.out.println("Thread Interrupted..." + Thread.currentThread().getName());
					break;
				}
				StockQuoteObservable obj = new StockQuoteObservable();
				LineChartObserver obj1 = new LineChartObserver();
				TableObserver obj2 = new TableObserver();
				ThreeDObserver obj3 = new ThreeDObserver();
				StockEvent stk=new StockEvent("DIS", 80000.0);
				System.out.println(Thread.currentThread().getName()+": "+stk.toString());
//				System.out.println("Adding Observers...");
//				System.out.println("Adding Observer 1"); 
				obj.addObserver(obj1);
//				System.out.println("Adding Observer 2"); 
				obj.addObserver(obj2);
//				System.out.println("Adding Observer 3"); 
				obj.addObserver(obj3);
//				System.out.println("Total Observers: "+countObservers()); 
				obj.changeQuote("META", 80000);
//				obj.changeQuote("DIS", 80000.0);
//				StockEvent event1 = (StockEvent) obj1;
//				StockEvent event2 = (StockEvent) obj2;
//				StockEvent event3 = (StockEvent) obj3;
//				System.out.println("Notifying observers...");
//				System.out.println("Notifying Observer 1");
//				notifyObservers(event1);
//				System.out.println("Notifying Observer 2");
//				notifyObservers(event2);
//				System.out.println("Notifying Observer 3");
//				notifyObservers(event3);
			} finally {
				lock.unlock();
			}
		}
	}

	public void run() {
		Runnable();
	}

}
