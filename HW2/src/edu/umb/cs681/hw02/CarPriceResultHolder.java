package edu.umb.cs681.hw02;

import java.util.*;
//import edu.umb.cs681.hw2.*;

public class CarPriceResultHolder {
	private int numCarExamined;
	private double average;
	

	
	public double getAverage() {
		return average;
    }
	
	public static void main(String[]args) {
		
		ArrayList<Car> cars=new ArrayList<Car>();
		Car obj1=new Car("Hyundai","Santro",2020,45000,20000);//year,mileage,price	
		Car obj2=new Car("BMW","X3",2019,15000,40000);
		Car obj3=new Car("Mercedes","AMG",2016,19000,45000);
		Car obj4=new Car("Toyota","Camry",2015,25000,28000);
		Car obj5=new Car("Kia","Sportage",2022,30000,56000);
		
		cars.add(obj1);
		cars.add(obj2);
		cars.add(obj3);
		cars.add(obj4);
		cars.add(obj5);
		
		
		System.out.print("Average price of all cars: ");
        Double averagePrice = cars.stream()
                .map(car->car.getPrice())
                .reduce(new CarPriceResultHolder(),(result, price) -> 
                {
                	double avg = (result.numCarExamined*result.average+price)/(++result.numCarExamined);
//                	System.out.println(avg);
                	result.average = avg;
                	return result;
                },
                (finalResult,intermediateResult)->finalResult).getAverage();
        
        System.out.println(averagePrice);
       
                //{double res=(+result.getprice())/numCarExamined++;
                //return result;}),(finalResult,intermediateResult)->finalResult).getAverage();
                
		
//		long count=cars.stream().count();	
		
	}


}
