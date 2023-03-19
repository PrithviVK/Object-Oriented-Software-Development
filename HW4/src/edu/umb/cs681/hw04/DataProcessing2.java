package edu.umb.cs681.hw04;

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

	
	public static void main(String[]args) throws IOException {
	
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
			
	
			
			OptionalDouble minPrice = price.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(medv)))
			        .min();
			System.out.println("Minimum Price: "+minPrice.getAsDouble());
			
			OptionalDouble maxPrice = price.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(medv)))
			        .max();
			System.out.println("Maximum Price: "+maxPrice.getAsDouble());
			
			OptionalDouble avgPrice = price.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(medv)))
			        .average();
			System.out.println("Average Price: "+avgPrice.getAsDouble());
			
			System.out.print("\n\n\n");
			
			OptionalDouble minNox = price.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(nox)))
			        .min();
			System.out.println("Minimum NOX: "+minNox.getAsDouble());
			
			OptionalDouble maxNox = price.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(nox)))
			        .max();
			System.out.println("Maximum NOX: "+maxNox.getAsDouble());
			
			OptionalDouble avgNox = price.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(nox)))
			        .average();
			System.out.println("Average NOX: "+avgNox.getAsDouble());
			
			System.out.print("\n\n\n");
			
			OptionalDouble minRooms = price.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(rm)))
			        .min();
			System.out.println("Minimum Rooms: "+minRooms.getAsDouble());
			
			OptionalDouble maxRooms = price.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(rm)))
			        .max();
			System.out.println("Maximum Rooms: "+maxRooms.getAsDouble());
			
			OptionalDouble avgRooms = price.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(rm)))
			        .average();
			System.out.println("Average Rooms: "+avgRooms.getAsDouble());
			

		}
		
		catch (IOException ex) {
			System.out.println("Error");}

	}
}
			


