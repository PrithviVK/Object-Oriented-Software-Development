package edu.umb.cs681.hw07;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;


public class FileSystem implements Runnable{
	private LinkedList<Directory> rootDirs = new LinkedList<Directory>();
	private static FileSystem instance=null;
	private static ReentrantLock lock = new ReentrantLock();
//	private static String name;
	
	private FileSystem() {

	}
	
	public static FileSystem getFileSystem() {
		lock.lock();
		try {
			if(instance==null) {
				instance=new FileSystem();
			}
		return instance;
		}
		finally {
			lock.unlock();
		}
	}
	
	public LinkedList<Directory> getRootDirs(){
		return this.rootDirs;
	}
	
	public void appendRootDir(Directory root) {
		this.rootDirs.add(root);
	}
	
	public void run() {
		getFileSystem();
	}
	
	
	public static void main(String[] args) {
		FileSystem fs1=new FileSystem();
		
//		FileSystem fs2=new FileSystem("Thread 2");
//		FileSystem fs3=new FileSystem("Thread 3");
//		FileSystem fs4=new FileSystem("Thread 4");

		Thread t1=new Thread(fs1);
		Thread t2=new Thread(fs1);
		Thread t3=new Thread(fs1);
		Thread t4=new Thread(fs1);
		
		
//		System.out.println(t1.getName());
		
		
		t1.start();
		System.out.println(t1.getName()+":");
		System.out.println(fs1.hashCode());
//		System.out.println(t1.hashCode());
		try {
		    t1.join();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		
		t2.start();
		System.out.println(t2.getName()+":");
		System.out.println(fs1.hashCode());
//		System.out.println(t2.hashCode());
		try {
		    t2.join();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		t3.start();
		System.out.println(t3.getName()+":");
		System.out.println(fs1.hashCode());
//		System.out.println(t3.hashCode());
		try {
		    t3.join();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		t4.start();
		System.out.println(t4.getName()+":");
		System.out.println(fs1.hashCode());
//		System.out.println(t4.hashCode());
		try {
		    t4.join();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		
	}
	
	
}