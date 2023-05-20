package edu.umb.cs681.hw09;
//import java.util.concurrent.locks.ReentrantLock;
import java.util.*;


public record Position(double latitude,double longitude,double altitude){
//	private final ReentrantLock lock = new ReentrantLock();
//	private final double latitude;
//	private final double longitude;
//	private final double altitude;
	
	
	public Position(double latitude, double longitude, double altitude) {
		this.latitude=latitude;
		this.longitude=longitude;
		this.altitude=altitude;
	}

	public Position change(double newLat, double newLong, double newAlt) {
		
		return new Position(newLat, newLong, newAlt);
	
	}
	
	public List<Double> coordinate(){
		List<Double> coordinates=new ArrayList<>();
		coordinates.add(this.latitude);
		coordinates.add(this.longitude);
		coordinates.add(this.altitude);
		return coordinates;
	}
	
	
	public boolean higherAltThan(Position anotherPosition) {
		boolean value=this.altitude>anotherPosition.altitude;
		return value;
	}
	
	public boolean lowerAltThan(Position anotherPosition) {
		boolean value=this.altitude<anotherPosition.altitude;
		return value;	
	}
	
	public boolean northOf(Position anotherPosition) {
		boolean value=this.longitude>anotherPosition.longitude;
		return value;
	}
	
	public boolean southOf(Position anotherPosition) {
		boolean value=this.longitude<anotherPosition.longitude;
		return value;
	}
	
	
	
}
