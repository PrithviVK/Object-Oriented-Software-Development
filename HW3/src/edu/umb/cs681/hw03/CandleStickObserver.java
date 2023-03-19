package edu.umb.cs681.hw03;

public  class CandleStickObserver implements Observer<WkSummary>{
	public void update(Observable<WkSummary> sender, WkSummary event) {
		System.out.println("Weekly Summary: ");
		System.out.println("\t Open: "+event.getOpen());
		System.out.println("\t High: "+event.getHigh());
		System.out.println("\t Low: "+event.getLow());
		System.out.println("\t Close: "+event.getClose());
		
	}
}
