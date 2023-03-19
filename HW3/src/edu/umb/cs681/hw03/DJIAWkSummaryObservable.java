package edu.umb.cs681.hw03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DJIAWkSummaryObservable extends Observable<WkSummary>{
	
	List<DSummary> collection=new ArrayList<DSummary>();

	public void addSummary(DSummary dSummary) {
		collection.add(dSummary);
		
		if(collection.size()==5) {
		
		List<Double> high=collection.stream().map((data)->(data.getHigh())).collect(Collectors.toList());
		
		List<Double> low=collection.stream().map((data)->(data.getLow())).collect(Collectors.toList());
		
		List<Double> open=collection.stream().map((data)->(data.getOpen())).collect(Collectors.toList());
		
		List<Double> close=collection.stream().map((data)->(data.getClose())).collect(Collectors.toList());
		

		
		Double openValue=open.get(0);
		Double closeValue=close.get(4);
		
		
		Double min= low.stream().mapToDouble(Double::doubleValue).min().getAsDouble();
		Double max= high.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
		

		CandleStickObserver cso = new CandleStickObserver();
		
		WkSummary wKSummary =new WkSummary(openValue, max, min, closeValue);
		
		DJIAWkSummaryObservable observable=new DJIAWkSummaryObservable();
		
		observable.addObserver(cso);
		observable.notifyObservers(wKSummary);
		
		collection.clear();


		}
		
	}
	
	public static void main(String[] args) throws IOException{
			Path path = Paths.get("HistoricalPrices.csv");
		
			try( Stream<String> lines = Files.lines(path))
			{
				List<List<String>> matrix =lines.map( line -> {
					return Stream.of( line.split(",") ).skip(1).map(value->value.substring((0))).collect(Collectors.toList());}).
						collect(Collectors.toList());
				
				DJIAWkSummaryObservable observable=new DJIAWkSummaryObservable();
				int six=6;
				for(int i = 1; i < six; i++) {
					observable.addSummary
					(new DSummary(Double.parseDouble(matrix.get(i).get(0)),Double.parseDouble(matrix.get(i).get(1)),
							Double.parseDouble(matrix.get(i).get(2)),Double.parseDouble(matrix.get(i).get(3))));
		        }			
					
			}
			
			catch (IOException ex) {
				System.out.println("Error");}
		
	}
}

