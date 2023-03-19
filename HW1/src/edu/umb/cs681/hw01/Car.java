package edu.umb.cs681.hw01;

import java.util.*;
import java.util.stream.Collectors;

public class Car {

	private String make, model;
	private int mileage, year;
	int dominationCount;
	private float price;
	int count = 0;
	
	public Car(String Make,String Model,int Year,int Mileage,float price) {
		this.make=Make;
		this.model=Model;
		this.year=Year;
		this.mileage=Mileage;
		this.price=price;
	}
	
	public int getDominationCount() {
		return count;
	}
	
	public void setDominationcount(ArrayList<Car> cars) {
		int index=0;
		while(index<cars.size()) {
			Car car=cars.get(index);
				if((this.getMileage()<=car.getMileage())){
					if((this.getYear()>=car.getYear())&&(this.getPrice()<=car.getPrice())) {
						count++;
					}
				}
			index++;
		}

        this.dominationCount = count;
    }
	
	public String getMake() {
		return make;
	}
	
//	public void setMake(String Make) {
//		this.make=Make;
//	}
	
	public String getModel() {
		return model;
	}
	
//	public void setModel(String Model) {
//		this.model=Model;
//	}
	
	public int getMileage() {
		return mileage;
	}
	
	public void setMileage(int Mileage) {
		this.mileage=Mileage;
	}
	
	public int getYear() {
		return year;
	}
	
//	public void setYear(int Year) {
//		this.year=Year;
//	}
	
	public float getPrice() {
		return price;
	}
	
	
	public static void Mileage() {
		ArrayList<Car> usedCars=new ArrayList<Car>();
		Car obj1=new Car("Hyundai","Santro",2020,45000,20000);//year,mileage,price	
		Car obj2=new Car("BMW","X3",2019,15000,40000);
		Car obj3=new Car("Mercedes","AMG",2016,19000,45000);
		Car obj4=new Car("Toyota","Camry",2015,25000,28000);
		Car obj5=new Car("Kia","Sportage",2022,30000,56000);
		

		usedCars.add(obj1);
		usedCars.add(obj2);
		usedCars.add(obj3);
		usedCars.add(obj4);
		usedCars.add(obj5);
		List<Car> sortedCars=usedCars.stream().sorted((Car car1, Car car2)-> car1.getMileage() - car2.getMileage()).
				collect(Collectors.toList());
		
		int threshold=30000;
		List<Integer> HIGH = new ArrayList<>();
		List<Integer> LOW = new ArrayList<>();
//		int HIGH[];
//		int LOW[];
			
		
		for(int i=0;i<sortedCars.size();i++) {
			if(sortedCars.get(i).getMileage()<=threshold){
				LOW.add(sortedCars.get(i).getMileage());
			}
			else {
				HIGH.add(sortedCars.get(i).getMileage());
			}
			
			
		}
		
		System.out.println("Min and Max values of LOW group: "+LOW);
		OptionalInt low_min= LOW.stream().mapToInt(Integer::intValue).min();
		OptionalInt low_max= LOW.stream().mapToInt(Integer::intValue).max();
		OptionalDouble low_average=LOW.stream().mapToDouble(Integer::intValue).average();
		long countLOWcars=LOW.stream().count();
		System.out.println("Min values: "+low_min.getAsInt());
		System.out.println("Max values: "+low_max.getAsInt());
		System.out.println("Average: "+low_average.getAsDouble());
		System.out.println("Count is: "+countLOWcars);
		
	
		
		
		System.out.println("Min and Max values of HIGH group: "+HIGH);
		OptionalInt high_min= HIGH.stream().mapToInt(Integer::intValue).min();
		OptionalInt high_max= HIGH.stream().mapToInt(Integer::intValue).max();
		OptionalDouble high_average=HIGH.stream().mapToDouble(Integer::intValue).average();
		long countHIGHcars=HIGH.stream().count();
		System.out.println("Min values: "+high_min.getAsInt());
		System.out.println("Max values: "+high_max.getAsInt());
		System.out.println("Average: "+high_average.getAsDouble());
		System.out.println("Count is: "+countHIGHcars);
		

	}
	
	public static void Year() {
		ArrayList<Car> usedCars=new ArrayList<Car>();
		Car obj1=new Car("Hyundai","Santro",2021,45000,20000);
		Car obj2=new Car("BMW","X3",2018,15000,40000);
		Car obj3=new Car("Mercedes","AMG",2016,19000,45000);
		Car obj4=new Car("Toyota","Camry",2015,25000,28000);
		Car obj5=new Car("Kia","Sportage",2022,30000,56000);


		usedCars.add(obj1);
		usedCars.add(obj2);
		usedCars.add(obj3);
		usedCars.add(obj4);
		usedCars.add(obj5);
		
//		YearComparator obj=new YearComparator();
//		Collections.sort(usedCars,obj);
		List<Car> sortedCars=usedCars.stream().sorted((Car car1, Car car2)-> car1.getYear() - car2.getYear()).
				collect(Collectors.toList());
		
		int threshold=2018;
		List<Integer> HIGH = new ArrayList<>();
		List<Integer> LOW = new ArrayList<>();
//		int HIGH[];
//		int LOW[];
			
		
		for(int i=0;i<sortedCars.size();i++) {
			if(sortedCars.get(i).getYear()<=threshold){
				LOW.add(sortedCars.get(i).getYear());
			}
			else {
				HIGH.add(sortedCars.get(i).getYear());
			}
			
			
		}
		
		System.out.println("Min and Max values of LOW group: "+LOW);
		OptionalInt low_min= LOW.stream().mapToInt(Integer::intValue).min();
		OptionalInt low_max= LOW.stream().mapToInt(Integer::intValue).max();
		OptionalDouble low_average=LOW.stream().mapToDouble(Integer::intValue).average();
		long countLOWcars=LOW.stream().count();
		System.out.println("Min values: "+low_min.getAsInt());
		System.out.println("Max values: "+low_max.getAsInt());
		System.out.println("Average: "+low_average.getAsDouble());
		System.out.println("Count is: "+countLOWcars);
		
	
		
		
		System.out.println("Min and Max values of HIGH group: "+HIGH);
		OptionalInt high_min= HIGH.stream().mapToInt(Integer::intValue).min();
		OptionalInt high_max= HIGH.stream().mapToInt(Integer::intValue).max();
		OptionalDouble high_average=HIGH.stream().mapToDouble(Integer::intValue).average();
		long countHIGHcars=HIGH.stream().count();
		System.out.println("Min values: "+high_min.getAsInt());
		System.out.println("Max values: "+high_max.getAsInt());
		System.out.println("Average: "+high_average.getAsDouble());
		System.out.println("Count is: "+countHIGHcars);

		
	}
	
	public static void Price() {
		ArrayList<Car> usedCars=new ArrayList<Car>();
		Car obj1=new Car("Hyundai","Santro",2020,45000,20000);
		Car obj2=new Car("BMW","X3",2017,15000,40000);
		Car obj3=new Car("Mercedes","AMG",2016,19000,45000);
		Car obj4=new Car("Toyota","Camry",2015,25000,28000);
		Car obj5=new Car("Kia","Sportage",2022,30000,56000);
		
		usedCars.add(obj1);
		usedCars.add(obj2);
		usedCars.add(obj3);
		usedCars.add(obj4);
		usedCars.add(obj5);
		
		
//		usedCars.stream().filter(null).sorted().forEach(n->System.out.println(n));
		List<Car> sortedCars = usedCars.stream()
				.sorted( Comparator.comparing((Car car)-> car.getPrice()) ) .collect( Collectors.toList());
		
		
		int threshold=40000;
		List<Integer> HIGH = new ArrayList<>();
		List<Integer> LOW = new ArrayList<>();
//		int HIGH[];
//		int LOW[];
			
		
		for(int i=0;i<sortedCars.size();i++) {
			if(sortedCars.get(i).getPrice()<=threshold){
				LOW.add((int) sortedCars.get(i).getPrice());
			}
			else {
				HIGH.add((int)sortedCars.get(i).getPrice());
			}
			
			
		}
		
		System.out.println("Min and Max values of LOW group: "+LOW);
		OptionalInt low_min= LOW.stream().mapToInt(Integer::intValue).min();
		OptionalInt low_max= LOW.stream().mapToInt(Integer::intValue).max();
		OptionalDouble low_average=LOW.stream().mapToDouble(Integer::intValue).average();
		long countLOWcars=LOW.stream().count();
		System.out.println("Min values: "+low_min.getAsInt());
		System.out.println("Max values: "+low_max.getAsInt());
		System.out.println("Average: "+low_average.getAsDouble());
		System.out.println("Count is: "+countLOWcars);
		
	
		
		
		System.out.println("Min and Max values of HIGH group: "+HIGH);
		OptionalInt high_min= HIGH.stream().mapToInt(Integer::intValue).min();
		OptionalInt high_max= HIGH.stream().mapToInt(Integer::intValue).max();
		OptionalDouble high_average=HIGH.stream().mapToDouble(Integer::intValue).average();
		long countHIGHcars=HIGH.stream().count();
		System.out.println("Min values: "+high_min.getAsInt());
		System.out.println("Max values: "+high_max.getAsInt());
		System.out.println("Average: "+high_average.getAsDouble());
		System.out.println("Count is: "+countHIGHcars);
		

	}

	public static void ParetoComparator() {
		ArrayList<Car> usedCars=new ArrayList<Car>();
		Car obj1=new Car("Hyundai","Santro",2020,45000,20000);//year,mileage,price	
		Car obj2=new Car("BMW","X3",2019,15000,40000);
		Car obj3=new Car("Mercedes","AMG",2016,19000,45000);
		Car obj4=new Car("Toyota","Camry",2015,25000,28000);
		Car obj5=new Car("Kia","Sportage",2022,30000,56000);
		Car obj6=new Car("Tesla","Model X",2023,450000,96000);
		Car obj7=new Car("Tesla","Model X",2023,450000,96000);
		usedCars.add(obj1);
		usedCars.add(obj2);
		usedCars.add(obj3);
		usedCars.add(obj4);
		usedCars.add(obj5);
		usedCars.add(obj6);
		usedCars.add(obj7);
		
		for(Car car:usedCars) {
			car.setDominationcount(usedCars);
		}
		
				
		List<Car> sortedCars=usedCars.stream().sorted((Car car1, Car car2)-> car1.getDominationCount() - car2.getDominationCount()).
				collect( Collectors.toList());
		
		for(int i=0;i<sortedCars.size();i++) {
			int j=i+1;
			System.out.println("For Car "+ j +": "+sortedCars.get(i).getDominationCount());
			}
		
		
		int threshold=1;
		List<Integer> HIGH = new ArrayList<>();
		List<Integer> LOW = new ArrayList<>();
			
		
		for(int i=0;i<sortedCars.size();i++) {
			if(sortedCars.get(i).getDominationCount()<=threshold){
				LOW.add((int) sortedCars.get(i).getDominationCount());
			}
			else {
				HIGH.add((int)sortedCars.get(i).getDominationCount());
			}
				
		}
		
		System.out.println(LOW);
		System.out.println(HIGH);
		
		System.out.println("Min and Max values of LOW group: "+LOW);
		OptionalInt low_min= LOW.stream().mapToInt(Integer::intValue).min();
		OptionalInt low_max= LOW.stream().mapToInt(Integer::intValue).max();
		OptionalDouble low_average=LOW.stream().mapToDouble(Integer::intValue).average();
		long countLOWcars=LOW.stream().count();
		System.out.println("Min values: "+low_min.getAsInt());
		System.out.println("Max values: "+low_max.getAsInt());
		System.out.println("Average: "+low_average.getAsDouble());
		System.out.println("Count is: "+countLOWcars);
		
	
		
		
		System.out.println("Min and Max values of HIGH group: "+HIGH);
		OptionalInt high_min= HIGH.stream().mapToInt(Integer::intValue).min();
		OptionalInt high_max= HIGH.stream().mapToInt(Integer::intValue).max();
		OptionalDouble high_average=HIGH.stream().mapToDouble(Integer::intValue).average();
		long countHIGHcars=HIGH.stream().count();
		System.out.println("Min values: "+high_min.getAsInt());
		System.out.println("Max values: "+high_max.getAsInt());
		System.out.println("Average: "+high_average.getAsDouble());
		System.out.println("Count is: "+countHIGHcars);
		
	}
	
	

	public static void main(String[]args) {
		System.out.println("For Price :");
		Car.Price();
		System.out.println("For Year :");
		Car.Year();
		System.out.println("For Mileage :");
		Car.Mileage();
		System.out.println("For Domination count");
		Car.ParetoComparator();

	}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

