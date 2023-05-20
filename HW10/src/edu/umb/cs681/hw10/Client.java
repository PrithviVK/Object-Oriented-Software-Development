package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Client extends FileSystem implements Runnable {
	protected final ReentrantLock lock = new ReentrantLock();
	private volatile boolean done = false;
	FileSystem fs = FileSystem.getFileSystem();

	public void setDone() {

		done = true;
	}

	public void Runnable() {
		
		
		while (true) {
			lock.lock();
			try {
				if (done) {
					System.out.println("Thread Interrupted..." + Thread.currentThread().getName());
					break;
				} else {
					LocalDateTime d1;
					LocalDateTime d2;
					Directory root;
					Directory home;
					Directory applications;
					Directory pictures;
					Directory binary;
					File x;
					File y;
					File a;
					File b;
					File c;
					Link d;
					Link e;

					d1 = LocalDateTime.now();

					d2 = LocalDateTime.now();

					root = new Directory(null, "root", 0, d1);

					home = new Directory(root, "home", 0, d1);

					applications = new Directory(root, "applications", 0, d1);
					x = new File(applications, "x", 0, d1);
					c = new File(home, "c", 3, d1);
					pictures = new Directory(home, "pictures", 0, d1);

					a = new File(pictures, "a", 0, d1);
					b = new File(pictures, "b", 0, d1);

					binary = new Directory(root, "bin", 0, d1);
					y = new File(binary, "y", 0, d1);

					d = new Link(root, "d", 0, d1, pictures);
					e = new Link(root, "e", 0, d2, x);

					fs.appendRootDir(root);
					System.out.println("Children of home:"+root.getChildren());
//					System.out.println("Number of children in root directory are: " + fs.getRootDirs().get(0).getChildren().size());
//					System.out.println("Number of children in pictures are "+fs.getRootDirs().get(0).getChildren().get(1).getName());
//			

				}

			} finally {
				lock.unlock();
			}

		}

	}

	@Override
	public void run() {
		Runnable();
	}

	public static void main(String[] args) {

		List<Client> handlers = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			Client handler = new Client();
			handlers.add(handler);
			Thread thread = new Thread(handler);
			threads.add(thread);
			thread.start();
			System.out.println("Running Thread:" + thread.getName());
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Client handler : handlers) {
			System.out.println("set done method -------" + handler.hashCode());
			handler.setDone();
		}

		for (Thread thread : threads) {
			System.out.println("Thread: " + thread.getName());
			thread.interrupt();
		}
	}
}
