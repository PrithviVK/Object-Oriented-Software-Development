package edu.umb.cs681.hw18;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class AccessCounter {
	private static volatile AccessCounter instance;
//    private static final Lock instanceLock = new ReentrantLock();

//	private final Map<Path, Integer> filePathMap = new HashMap<>();
	private final ConcurrentHashMap<Path, Integer> map = new ConcurrentHashMap<>();
//	private final Lock lock = new ReentrantLock();

	private AccessCounter() {
	}

	public static AccessCounter getInstance() {
		if (instance == null) {
			if (instance == null) {
				instance = new AccessCounter();
			}
		}
		return instance;
	}

	public void increment(Path filePath) {
		map.compute(filePath, (Path key, Integer value) -> (value == null) ? 1 : value + 1);

	}

	public int getCount(Path filePath) {
		return map.getOrDefault(filePath, 0);
	}
}
