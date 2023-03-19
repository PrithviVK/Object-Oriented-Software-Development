package edu.umb.cs681.hw04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessing3 {
	final static int chas=3;
	final static int crim=0;
	
	public static void main(String[] args) throws IOException{
		
		//Data Processing to get criminal activities near Charles river
		 Path path = Paths.get("bos-housing.csv");
			
			try( Stream<String> lines = Files.lines(path))
			{
//				List<List<String>> matrix =lines.map( line -> {
//					return Stream.of( line.split(",") ).map(value->value.substring((0))).collect(Collectors.toList());}).
//						collect(Collectors.toList());
				List<List<String>> matrix =lines.map( line -> 
					Stream.of( line.split(",") ).collect(Collectors.toList())).
						collect(Collectors.toList());
					
					List<String> crime=matrix.stream().filter((data)->data.get(chas).contains("1"))
							.map(row -> row.get(crim)).collect(Collectors.toList());
					
//					System.out.println(crime);
					
					List<Float> c =crime.stream().map(Float::parseFloat).collect(Collectors.toList());
					
					OptionalDouble min= c.stream().mapToDouble(Float::intValue).min();
					OptionalDouble max= c.stream().mapToDouble(Float::intValue).max();
					OptionalDouble avg= c.stream().mapToDouble(Float::intValue).average();
					
					System.out.println("Minimum Crime: "+min.getAsDouble());
					System.out.println("Maximum Crime: "+max.getAsDouble());
					System.out.println("Average Crime: "+avg.getAsDouble());
					
			}
			catch (IOException ex) {
				System.out.println("Error");}

		
		
	}
}
