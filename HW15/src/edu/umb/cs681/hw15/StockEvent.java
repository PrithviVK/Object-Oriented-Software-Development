package edu.umb.cs681.hw15;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public record StockEvent(String ticker, double quote) {

	private static final Lock lock = new ReentrantLock();
	public StockEvent(String ticker, double quote) {
		this.ticker = ticker;
		this.quote = quote;
	}

	public String getTicker() {
		lock.lock();
		try {
			return this.ticker;
		} finally {
			lock.unlock();
		}
	}

	public double getQuote() {
		lock.lock();
		try {
		return this.quote;
		}
		finally {
			lock.unlock();
		}
	}

}