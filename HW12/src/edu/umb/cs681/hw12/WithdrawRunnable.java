package edu.umb.cs681.hw12;

import java.util.concurrent.locks.ReentrantLock;

public class WithdrawRunnable implements Runnable {
	private volatile boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	private BankAccount account;
//	ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();

	public WithdrawRunnable(ThreadSafeBankAccount2 bankAccount) {
		this.account = bankAccount;
	}

	public void setDone() {
		lock.lock();
		try {
			done = true;
		} finally {
			lock.unlock();
		}
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			if (done) {
				System.out.println("Terminating...");
				break;
				}
			System.out.println("Depositing...");
			account.withdraw(100);
		}}
	}

//try {
//	for (int i = 0; i < 10; i++) {
//		if (done) {
//			System.out.println("Terminating...");
//			break;
//			}
//		System.out.println("Depositing...");
//		account.withdraw(100);
//		Thread.sleep(3000);
//	}
// }catch (InterruptedException e) {
//	e.printStackTrace();
//}}
//		while (!Thread.interrupted()) {
//			lock.lock();
//			try {
//				if (done) {
//					System.out.println("terminating...");
//					break;
//				}
//			} finally {
//				lock.unlock();
//			}
//
//			System.out.println("Withdrawing...");
//			account.withdraw(100);
//
//			try {
//				Thread.sleep(3000);
//			}
//
//			catch (InterruptedException e) {
//				return;
////				e.printStackTrace();
//				
//			}
//
//		}

