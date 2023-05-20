package edu.umb.cs681.hw11;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
    private static volatile AccessCounter instance;
    private static final Lock instanceLock = new ReentrantLock();

    private final Map<Path, Integer> filePathMap = new HashMap<>();
    private final Lock lock = new ReentrantLock();

    private AccessCounter() {}

    public static AccessCounter getInstance() {
            instanceLock.lock();
            try {
                if (instance == null) {
                    instance = new AccessCounter();
                }
            } finally {
                instanceLock.unlock();
            }
        return instance;
    }

    public void increment(Path filePath) {
        lock.lock();
        try {
            int count = filePathMap.getOrDefault(filePath, 0);
            filePathMap.put(filePath, count + 1);
        } finally {
            lock.unlock();
        }
    }

    public int getCount(Path filePath) {
        lock.lock();
        try {
            return filePathMap.getOrDefault(filePath, 0);
        } finally {
            lock.unlock();
        }
    }
}
