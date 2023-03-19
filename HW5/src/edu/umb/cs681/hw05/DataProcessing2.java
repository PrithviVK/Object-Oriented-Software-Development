package edu.umb.cs681.hw05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessing2  {
	final static int crim=0;
	final static int ptratio=10;
	final static int medv=13;
	final static int nox=4;
	final static int rm=5;
	
	public void DP2() {

	Path path = Paths.get("bos-housing.csv");

	try( Stream<String> lines = Files.lines(path))
	{
		List<List<String>> matrix =lines.map( line -> 
		Stream.of(line.split(",") ).collect(Collectors.toList())).
				collect(Collectors.toList());

		List<List<String>> crime=matrix.stream().skip(1).sorted(Comparator.comparingDouble(a->Double.parseDouble(a.get(crim)))).
				limit((int) Math.ceil(matrix.size() * 0.1)).collect(Collectors.toList());
		
		List<List<String>> ratio=matrix.stream().skip(1).sorted(Comparator.comparingDouble(a->Double.parseDouble(a.get(ptratio)))).
				limit((int) Math.ceil(matrix.size() * 0.1)).collect(Collectors.toList());
		
		List<List<String>> price=new ArrayList<List<String>>(crime);
		price.retainAll(ratio);
		
		
//		List<Integer> price_consolidated=new ArrayList<Integer>();
//		for(int i=0;i<price.size();i++) {
//			price_consolidated.add(price.get(i));
//		}
//		System.out.println(price);
		
		
		Double minPrice = price.stream()
				.mapToDouble(a -> Double.parseDouble(a.get(medv)))
		        .min().getAsDouble();
//		System.out.println("Minimum Price: "+minPrice.getAsDouble());
		
		Double maxPrice = price.stream()
				.mapToDouble(a -> Double.parseDouble(a.get(medv)))
		        .max().getAsDouble();
//		System.out.println("Maximum Price: "+maxPrice.getAsDouble());
		
		Double avgPrice = price.stream()
				.mapToDouble(a -> Double.parseDouble(a.get(medv)))
		        .average().getAsDouble();
		
		System.out.println("Minimum Price: "+minPrice);
		System.out.println("Maximum Price: "+maxPrice);
		System.out.println("Average Price: "+avgPrice);
		
//		DataProcessingRunnable runnable2 = new DataProcessingRunnable(minPrice,maxPrice,avgPrice);
//		Thread t2=new Thread(runnable2);
//		t2.start();
//		System.out.println("Average Price: "+avgPrice.getAsDouble());
		
		System.out.print("\n");
		
		Double minNox = price.stream()
				.mapToDouble(a -> Double.parseDouble(a.get(nox)))
		        .min().getAsDouble();
//		System.out.println("Minimum NOX: "+minNox.getAsDouble());
		
		Double maxNox = price.stream()
				.mapToDouble(a -> Double.parseDouble(a.get(nox)))
		        .max().getAsDouble();
//		System.out.println("Maximum NOX: "+maxNox.getAsDouble());
		
		Double avgNox = price.stream()
				.mapToDouble(a -> Double.parseDouble(a.get(nox)))
		        .average().getAsDouble();
		
		System.out.println("Minimum Nox: "+minNox);
		System.out.println("Maximum Nox: "+maxNox);
		System.out.println("Average Nox: "+avgNox);
		
//		DataProcessingRunnable runnable3 = new DataProcessingRunnable(minNox,maxNox,avgNox);
//		Thread t3=new Thread(runnable3);
//		t3.start();
//		System.out.println("Average NOX: "+avgNox.getAsDouble());
		
		System.out.print("\n");
		
		Double minRooms = price.stream()
				.mapToDouble(a -> Double.parseDouble(a.get(rm)))
		        .min().getAsDouble();
//		System.out.println("Minimum Rooms: "+minRooms.getAsDouble());
		
		Double maxRooms = price.stream()
				.mapToDouble(a -> Double.parseDouble(a.get(rm)))
		        .max().getAsDouble();
//		System.out.println("Maximum Rooms: "+maxRooms.getAsDouble());
		
		Double avgRooms = price.stream()
				.mapToDouble(a -> Double.parseDouble(a.get(rm)))
		        .average().getAsDouble();
		
		System.out.println("Minimum Rooms: "+minRooms);
		System.out.println("Maximum Rooms: "+maxRooms);
		System.out.println("Average Rooms: "+avgRooms);
		
//		DataProcessingRunnable runnable4 = new DataProcessingRunnable(minRooms,maxRooms,avgRooms);
//		Thread t4=new Thread(runnable4);
//		t4.start();
//		System.out.println("Average Rooms: "+avgRooms.getAsDouble());

	}
	
	catch (IOException ex) {
		System.out.println("Error");}
	}


//	public static void main(String[]args) throws IOException {}
	
		
}
			
			
		
	

