package edu.umb.cs681.hw16.revised;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MeterManager {
	// Singleton pattern - volatile ensures visibility of shared instance among threads
	private static volatile MeterManager instance;
	// Lock for instance creation synchronization
	private static final Lock instanceLock = new ReentrantLock();
	// Lock for accessing and modifying MeterMap
	private final Lock lock = new ReentrantLock();

	private final Map<String, Integer> MeterMap = new HashMap<>();
	
	// Private constructor to prevent direct instantiation
	private MeterManager() {
	}
	// Singleton pattern - ensures only one instance of MeterManager is created
	public static MeterManager getInstance() {
		instanceLock.lock();
		try {
			if (instance == null) {
				instance = new MeterManager();
			}
		} finally {
			instanceLock.unlock();
		}

		return instance;
	}
	// Increment the count for a specific meter
	public void incrementMeterCount(String meter) {
		lock.lock();
		try {// Get the current count for the meter, default to 0 if not present
			int count = MeterMap.getOrDefault(meter, 0);
			// Update the count by adding 10 to it
			MeterMap.put(meter, count + 10);
		} finally {
			lock.unlock();
		}

	}
	
	// Get the count for a specific meter
	public int getMeterCount(String meter) {
		lock.lock();
		try {
			// Get the count for the meter, default to 0 if not present
			return MeterMap.getOrDefault(meter, 0);
		} finally {
			lock.unlock();
		}

	}
}
