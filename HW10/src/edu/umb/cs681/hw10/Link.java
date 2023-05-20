package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
//import java.util.concurrent.locks.ReentrantLock;

//import java.util.concurrent.locks.ReentrantReadWriteLock;
public class Link extends FSElement {

	private FSElement target;
//	private final ReentrantLock lock = new ReentrantLock();

	public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
		super(parent, name, 0, creationTime);
		this.target = target;

	}

	public int getTargetsize() {
		lock.lock();
		try {
			return target.getSize();
		} finally {
			lock.unlock();
		}
	}

	public void setTarget(FSElement target) {
		lock.lock();
		try {
			this.target = target;
		} finally {
			lock.unlock();
		}
	}

	public FSElement getTarget() {
		lock.lock();
		try {
			return this.target;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean isDirectory() {
		lock.lock();
		try {
			return false;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean isFile() {
		lock.lock();
		try {
			return false;
		} finally {
			lock.unlock();
		}
	}

	public boolean isLink() {
		lock.lock();
		try {
			return true;
		} finally {
			lock.unlock();
		}
	}

	public boolean isTargetDirectory() {
		lock.lock();
		try {
			return target.isDirectory();
		} finally {
			lock.unlock();
		}
	}

	public boolean isTargetFile() {
		lock.lock();
		try {
			return target.isFile();
		} finally {
			lock.unlock();
		}
	}

	public boolean isTargetLink() {
		lock.lock();
		try {
			return target.isLink();
		} finally {
			lock.unlock();
		}
	}

}
