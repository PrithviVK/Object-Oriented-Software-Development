package edu.umb.cs681.hw16.original;

import java.util.HashMap;
import java.util.Map;


public class MeterManager {
	// Singleton pattern - volatile ensures visibility of shared instance among threads
	private static volatile MeterManager instance;
	
	// HashMap to store meter counts
	private final Map<String, Integer> MeterMap = new HashMap<>();
	
	// Private constructor to prevent direct instantiation
	private MeterManager() {
	}
	
	// Singleton pattern - ensures only one instance of MeterManager is created
	public static MeterManager getInstance() {

		if (instance == null) {
			instance = new MeterManager();
		}

		return instance;
	}
	// Increment the count for a specific meter
	public void incrementMeterCount(String meter) {

		int count = MeterMap.getOrDefault(meter, 0);
		MeterMap.put(meter, count + 10);

	}
	
	// Get the count for a specific meter
	public int getMeterCount(String meter) {
		// Get the count for the meter, default to 0 if not present
		return MeterMap.getOrDefault(meter, 0);

	}
}
