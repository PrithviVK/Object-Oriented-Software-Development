package edu.umb.cs681.hw15;

public class ThreeDObserver implements Observer<StockEvent>{
	
	public void update(Observable<StockEvent> sender,StockEvent event ) {
		System.out.println("ThreeDObserver");
		System.out.println("Ticker "+event.getTicker());
		System.out.println("Quote "+event.getQuote());
	}

//	@Override
//	public void update(Observable sender, Object event) {
//		
//		
//	}

}