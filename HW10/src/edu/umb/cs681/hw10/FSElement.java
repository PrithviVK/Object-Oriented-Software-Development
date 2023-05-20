package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
	public Directory parent;
	protected String name;
	protected int size;
	protected static LocalDateTime creationTime;
	protected final ReentrantLock lock = new ReentrantLock();

	public FSElement(Directory parent, String name, int size, LocalDateTime creationTime) {
		this.name = name;
		this.size = size;
		this.creationTime = creationTime;
		this.parent = parent;
	}

	public Directory getParent() {
		lock.lock();
		try {
			return this.parent;
		} finally {
			lock.unlock();
		}
	}

	public void setParent(Directory parent) {
		lock.lock();
		try {
			this.parent = parent;
		} finally {
			lock.unlock();
		}
	}

	public int getSize() {
		lock.lock();
		try {
			return this.size;
		} finally {
			lock.unlock();
		}
	}

	public void setSize(int size) {
		lock.lock();
		try {
			if (this.isDirectory()) {
				this.size = 0;
			} else {
				this.size = size;
			}
		} finally {
			lock.unlock();
		}
	}

	public String getName() {
		lock.lock();
		try {
			return this.name;
		} finally {
			lock.unlock();
		}
	}

	public void setName(String name) {
		lock.lock();
		try {
			this.name = name;
		} finally {
			lock.unlock();
		}
	}

	public LocalDateTime getDateTime() {

		return this.creationTime;

	}

	public void setDateTime(LocalDateTime creationTime) {

		this.creationTime = creationTime;

	}

	public abstract boolean isDirectory();

	public abstract boolean isFile();

	protected abstract boolean isLink();
}
