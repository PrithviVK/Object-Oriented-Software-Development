package edu.umb.cs681.hw12;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ThreadSafeBankAccount2 implements BankAccount {
	private double balance = 0;
	private ReentrantLock lock = new ReentrantLock();
	private Condition sufficientFundsCondition = lock.newCondition();
	private Condition belowUpperLimitFundsCondition = lock.newCondition();

	public void deposit(double amount) {
		lock.lock();
		try {
			System.out.println("Lock obtained");
			System.out.println(Thread.currentThread().getId() + " (d): current balance: " + balance);
			while (balance >= 300) {
				System.out.println(Thread.currentThread().getId() + " (d): await(): Balance exceeds the upper limit.");
				try {
					belowUpperLimitFundsCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			balance += amount;
			System.out.println(Thread.currentThread().getId() + " (d): new balance: " + balance);
			sufficientFundsCondition.signalAll();
		}

		finally {
			lock.unlock();
			System.out.println("Lock released");
		}
	}

	public void withdraw(double amount) {
		lock.lock();
		try {
			System.out.println("Lock obtained");
			System.out.println(Thread.currentThread().getId() + " (w): current balance: " + balance);
			while (balance <= 0) {
				System.out.println(Thread.currentThread().getId() + " (w): await(): Insufficient funds");
				try {
					sufficientFundsCondition.await();
				} catch (InterruptedException e) {
//					return;
					e.printStackTrace();
				}
			}
			balance -= amount;
			System.out.println(Thread.currentThread().getId() + " (w): new balance: " + balance);
			belowUpperLimitFundsCondition.signalAll();

		} finally {
			lock.unlock();
			System.out.println("Lock released");
		}
	}

	public double getBalance() {
		lock.lock();
		try {
			return this.balance;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		ThreadSafeBankAccount2 bankAccount = new ThreadSafeBankAccount2();
		for (int i = 0; i < 5; i++) {
			new Thread(new DepositRunnable(bankAccount)).start();
			new Thread(new WithdrawRunnable(bankAccount)).start();
		}

	}
}
