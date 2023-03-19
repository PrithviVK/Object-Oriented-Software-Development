package edu.umb.cs681.hw05;

public class DataProcessingRunnable {
	
	public static void main (String []args) {
		DataProcessing1 obj1=new DataProcessing1();
		Thread t1=new Thread(()->{
			obj1.DP1();
		});
		System.out.println(t1.getName()+":");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n");
		
		DataProcessing2 obj2=new DataProcessing2();
		Thread t2=new Thread(()->{
			obj2.DP2();
		});
		System.out.println(t2.getName()+":");
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n");
		
		DataProcessing3 obj3=new DataProcessing3();
		Thread t3=new Thread(()->{
			obj3.DP3();
		});
		System.out.println(t3.getName()+":");
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n");
		
		DataProcessing4 obj4=new DataProcessing4();
		Thread t4=new Thread(()->{
			obj4.DP4();
		});
		System.out.println(t4.getName()+":");
		t4.start();
		try {
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
