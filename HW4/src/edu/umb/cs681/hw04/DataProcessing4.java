package edu.umb.cs681.hw04;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataProcessing4 {
	
	final static int medv=13;
	final static int rad=8;
	
	public static void main(String[] args) throws IOException {
		
		//Data Processing to get houses of low price with least accessibility to highway
		
		Path path = Paths.get("bos-housing.csv");

		try( Stream<String> lines = Files.lines(path))
		{
//			List<List<String>> matrix =lines.map( line -> {
//				return Stream.of( line.split(",") ).map(value->value.substring((0))).collect(Collectors.toList());}).
//					collect(Collectors.toList());
			List<List<String>> matrix =lines.map( line -> 
				Stream.of( line.split(",") ).collect(Collectors.toList())).
					collect(Collectors.toList());
			
			List<List<String>> house_price=matrix.stream().skip(1).
					sorted(Comparator.comparing(a->Double.parseDouble(a.get(medv)))).
					limit(100).collect(Collectors.toList());
			
//			System.out.println(house_price);
			
			List<List<String>> highway=matrix.stream().skip(1)
					.sorted(Comparator.comparing(a->Double.parseDouble(a.get(rad)))).
					limit(100).collect(Collectors.toList());
			
//			System.out.println(highway);
			
			
			List<List<String>>least_accessibility =new ArrayList<List<String>>();
			least_accessibility=highway;
			least_accessibility.retainAll(house_price);
			
			
			OptionalDouble min_accessibility = least_accessibility.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(rad)))
			        .min();
			System.out.println("Minimum accessibility: "+min_accessibility.getAsDouble());
			
			OptionalDouble max_accessibility = least_accessibility.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(rad)))
			        .max();
			System.out.println("Maximum accessibility: "+max_accessibility.getAsDouble());
			
			OptionalDouble avg_accessibility = least_accessibility.stream()
					.mapToDouble(a -> Double.parseDouble(a.get(rad)))
			        .average();
			System.out.println("Average accessibility: "+avg_accessibility.getAsDouble());
			
		}
	
		catch (IOException ex) {
			System.out.println("Error");}

	}
	
}
	
	
