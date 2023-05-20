package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class File extends FSElement{
	public File(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
	}
	
	private static ReentrantLock lock = new ReentrantLock();

	@Override
	public boolean isDirectory() {
		lock.lock();
		try {
		return false;
		}
		finally {
			lock.unlock();
		}
	}

	@Override
	public boolean isFile() {
		lock.lock();
		try {
		return true;
		}
		finally {
			lock.unlock();
		}
	}

	@Override
	protected boolean isLink() {
		lock.lock();
		try {
		return false;
		}
		finally {
			lock.unlock();
		}
	}

}