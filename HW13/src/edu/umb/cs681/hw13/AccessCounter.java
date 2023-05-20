package edu.umb.cs681.hw13;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AccessCounter implements ReadWriteLock {
	private static volatile AccessCounter instance;
	private static final Lock instanceLock = new ReentrantLock();

	private final Map<Path, Integer> filePathMap = new HashMap<>();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	private AccessCounter() {
	}

	public static AccessCounter getInstance() {
		if (instance == null) {
			instanceLock.lock();
			try {
				if (instance == null) {
					instance = new AccessCounter();
				}
			} finally {
				instanceLock.unlock();
			}
		}
		return instance;
	}

	public void increment(Path filePath) {
		lock.writeLock().lock();
		try {
			int count = filePathMap.getOrDefault(filePath, 0);
			filePathMap.put(filePath, count + 1);
		} finally {
			lock.writeLock().unlock();
		}
	}

	public int getCount(Path filePath) {
		lock.readLock().lock();;
		try {
			return filePathMap.getOrDefault(filePath, 0);
		} finally {
			lock.readLock().unlock();
		}
	}

	@Override
	public Lock readLock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lock writeLock() {
		// TODO Auto-generated method stub
		return null;
	}
}
