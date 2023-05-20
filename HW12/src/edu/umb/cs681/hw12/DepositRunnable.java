package edu.umb.cs681.hw12;

import java.util.concurrent.locks.ReentrantLock;

public class DepositRunnable implements Runnable {
	private volatile boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	private BankAccount account;
//	ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();

	public DepositRunnable(ThreadSafeBankAccount2 bankAccount) {
		this.account = bankAccount;
	}

	public void setDone() {
		lock.lock();
		try {
			done = true;
//			interrupt();
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
			account.deposit(100);

		}
		
	}

}
