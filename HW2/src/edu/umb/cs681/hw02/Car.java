package edu.umb.cs681.hw02;
//import java.util.*;

public class Car {
	private String make, model;
	private int mileage, year;
	private float price;
	
	public Car(String Make,String Model,int Year,int Mileage,float price) {
		this.make=Make;
		this.model=Model;
		this.year=Year;
		this.mileage=Mileage;
		this.price=price;
		}
		
		
		public String getMake() {
			return make;
			
		}
		
		public String getModel() {
			return model;
		}
	
		
		public int getMileage() {
			return mileage;
		}
		
		public void setMileage(int Mileage) {
			this.mileage=Mileage;
		}
		
		public int getYear() {
			return year;
		}
		
		public float getPrice() {
			return price;
		}
		
	}


