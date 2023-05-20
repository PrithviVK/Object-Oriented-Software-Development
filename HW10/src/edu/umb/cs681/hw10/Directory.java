package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.LinkedList;
//import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantLock;

public class Directory extends FSElement {
	private final LinkedList<FSElement> children = new LinkedList<FSElement>();
	private final LinkedList<Directory> subDirectories = new LinkedList<Directory>();
	private final LinkedList<File> files = new LinkedList<File>();
	private final ReentrantLock lock = new ReentrantLock();

	public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size, creationTime);
		if (parent == null) {
			FileSystem nfs = FileSystem.getFileSystem();
			nfs.appendRootDir(this);
		} else {
			parent.appendChild(this);
//			System.out.println("child added");
		}

	}

	public LinkedList<FSElement> getChildren() {
		lock.lock();
		try {
//			return this.children;
			return new LinkedList<>(this.children);
		} finally {
			lock.unlock();
		}

	}

	public void appendChild(FSElement child) {
		lock.lock();
		try {
			this.children.add(child);
			child.setParent(this);
		} finally {
			lock.unlock();
		}

	}

	public int countChildren() {
		lock.lock();
		try {
			return this.children.size();
		} finally {
			lock.unlock();
		}
	}

	public LinkedList<Directory> getSubDirectories() {
		lock.lock();
		try {
			for (FSElement iterator : children) {
				if (iterator.isDirectory()) {
					subDirectories.add((Directory) iterator);
				}
			}
//			return this.subDirectories;
			return new LinkedList<>(this.subDirectories);
		} finally {
			lock.unlock();
		}
	}

	public LinkedList<File> getFiles() {
		lock.lock();
		try {
			for (FSElement iterator : children) {
				if (iterator.isFile()) {
					files.add((File) iterator);
				}
			}
//			return this.files;
			return new LinkedList<>(this.files);
		} finally {
			lock.unlock();
		}
	}

	public int getTotalSize() {
		lock.lock();
		try {
			int totalSize = 0;
			for (FSElement iterator : children) {
				if (iterator.isDirectory()) {
					totalSize += ((Directory) iterator).getTotalSize();
				} else {
					totalSize += iterator.getSize();
				}
			}
			return totalSize;
		} finally {
			lock.unlock();
		}
	}

	@Override
	public boolean isFile() {
		return false;
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	@Override
	protected boolean isLink() {
		return false;
	}

	public static void main(String[] args) {

		LocalDateTime d1;
		LocalDateTime d2;
		Directory root;
		Directory home;
		Directory applications;
		File x;
		File y;
		Directory library;
		File z;
		Directory code;
		File a;
		File b;
		File c;
		File d;
		d1 = LocalDateTime.now();
		d2 = LocalDateTime.now();

		root = new Directory(null, "root", 0, d1);

		home = new Directory(root, "home", 0, d1);

		applications = new Directory(root, "applications", 0, d1);
		x = new File(applications, "x", 3, d1);
		y = new File(applications, "y", 4, d2);

		library = new Directory(root, "library", 0, d1);
		z = new File(library, "z", 5, d1);

		code = new Directory(home, "code", 0, d1);
		a = new File(code, "a", 6, d1);
		b = new File(code, "b", 7, d2);
		c = new File(code, "c", 8, d2);

		d = new File(home, "d", 8, d1);
		System.out.println(root.getTotalSize());
		;
	}

}
