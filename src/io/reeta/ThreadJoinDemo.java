package io.reeta;

public class ThreadJoinDemo {
	public static void main(String[] args)throws InterruptedException {
		MyThreadJoin.mainThread = Thread.currentThread();
		MyThreadJoin myThreadJoin = new MyThreadJoin();
		Thread thread = new Thread(myThreadJoin);
		thread.start();
		//thread.join(); // Deadlock as child waiting for main to finish and main waiting for child to finish
		//Thread.currentThread().join(); // Main thread waiting for itself to complete it will results into deadlock;
		for(int i=0; i<=5; i++) {
			System.out.println("Main Thread");
		}
	}
}

class MyThreadJoin extends Thread{
	public static Thread mainThread;
	public void run() {
		try {
			mainThread.join();
		}catch (InterruptedException e) {}
		for(int i=0; i<=5; i++) {
			System.out.println("Child Thread");
		}
	}
}
