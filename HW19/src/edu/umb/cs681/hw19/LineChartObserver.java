package edu.umb.cs681.hw19;


public class LineChartObserver implements Observer<StockEvent> {
@Override
	public void update(Observable<StockEvent> sender,StockEvent event ) {
		System.out.println("LineChartObserver");
		System.out.println("Ticker " + event.getTicker());
		System.out.println("Quote " + event.getQuote());
	}


}
