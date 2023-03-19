package edu.umb.cs681.hw05;
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

	public void DP1() {
		
		Path path = Paths.get("bos-housing.csv");
		
		try( Stream<String> lines = Files.lines(path))
		{

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
				Double min= p.stream().mapToDouble(Float::doubleValue).min().getAsDouble();
				Double max= p.stream().mapToDouble(Float::doubleValue).max().getAsDouble();				
				Double avg= p.stream().mapToDouble(Float::doubleValue).average().getAsDouble();	
				
				
//				t1.join();
//				
				System.out.println("Minimum Price: "+min);
				System.out.println("Maximum Price: "+max);
				System.out.println("Average Price: "+avg);
				
		}
		catch (IOException ex) {
			System.out.println("Error");}
	}
	
//	public static void main(String[] args) throws IOException, InterruptedException {
//
//		
//	}
//	
	
	
}
