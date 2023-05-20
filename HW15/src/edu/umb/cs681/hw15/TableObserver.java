package edu.umb.cs681.hw15;

public class TableObserver implements Observer<StockEvent> {

	@Override
	public void update(Observable<StockEvent> sender, StockEvent event) {
		System.out.println("TableObserver");
		System.out.println("Ticker "+event.getTicker());
		System.out.println("Quote "+event.getQuote());
	}

}