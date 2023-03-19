package edu.umb.cs681.hw05;

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
	
	public void DP3() {
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
					
					Double min= c.stream().mapToDouble(Float::intValue).min().getAsDouble();
					Double max= c.stream().mapToDouble(Float::intValue).max().getAsDouble();
					Double avg= c.stream().mapToDouble(Float::intValue).average().getAsDouble();
					
					System.out.println("Minimum Crime: "+min);
					System.out.println("Maximum Crime: "+max);
					System.out.println("Average Crime: "+avg);
					
			}
			catch (IOException ex) {
				System.out.println("Error");}

		
		
	}
	
//	public static void main(String[] args) throws IOException{
//		
//	}
}
