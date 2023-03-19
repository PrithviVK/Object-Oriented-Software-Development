package edu.umb.cs681.hw04;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DataProcessing1 {
	
final static int chas=3;
final static int medv=13;

	
	
	public static void main(String[] args) throws IOException {
		
	    Path path = Paths.get("bos-housing.csv");
		
		try( Stream<String> lines = Files.lines(path))
		{
//			List<List<String>> matrix =lines.map( line -> {
//				return Stream.of( line.split(",") ).map(value->value.substring((0))).collect(Collectors.toList());}).
//					collect(Collectors.toList());
			List<List<String>> matrix =lines.map( line -> 
				Stream.of( line.split(",") ).collect(Collectors.toList())).
					collect(Collectors.toList());
				
				List<String> price=matrix.stream().filter((data)->data.get(chas).contains("1"))
						.map(row -> row.get(medv)).collect(Collectors.toList());
//				
//				Long price=matrix.stream().filter((data)->data.get(chas).contains("1"))
//						.map(row -> row.get(medv)).count();
				
//				System.out.println(price);
				
//				
				List<Float> p =price.stream().map(Float::parseFloat).collect(Collectors.toList());
//				
				OptionalDouble min= p.stream().mapToDouble(Float::doubleValue).min();
				OptionalDouble max= p.stream().mapToDouble(Float::doubleValue).max();
				OptionalDouble avg= p.stream().mapToDouble(Float::doubleValue).average();
//				
				System.out.println("Minimum values: "+min.getAsDouble());
				System.out.println("Maximum values: "+max.getAsDouble());
				System.out.println("Average values: "+avg.getAsDouble());
				
		}
		catch (IOException ex) {
			System.out.println("Error");}

		
	}
	
	
	
}
