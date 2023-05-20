package edu.umb.cs681.hw12;

public class Client {
	public static void main(String[] args) {

		ThreadSafeBankAccount2 bankAccount = new ThreadSafeBankAccount2();
		DepositRunnable d1 = new DepositRunnable(bankAccount);
		WithdrawRunnable w1 = new WithdrawRunnable(bankAccount);
		DepositRunnable d2 = new DepositRunnable(bankAccount);
		WithdrawRunnable w2 = new WithdrawRunnable(bankAccount);

		Thread dt1 = new Thread(d1);
		Thread dt2 = new Thread(d2);
		Thread wt1 = new Thread(w1);
		Thread wt2 = new Thread(w2);

		System.out.println("Running threads...");

		dt1.start();
		dt2.start();
		wt1.start();
		wt2.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}

		d1.setDone();
		d2.setDone();
		w1.setDone();
		w2.setDone();
		
		dt1.interrupt();
		dt2.interrupt();
		wt1.interrupt();
		wt2.interrupt();

	}

}
