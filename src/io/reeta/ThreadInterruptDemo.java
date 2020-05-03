package io.reeta;

public class ThreadInterruptDemo {

	public static void main(String[] args) {

		MyThreadInterrupt interrupt = new MyThreadInterrupt();
		interrupt.start();
		interrupt.interrupt();
	}
}

class MyThreadInterrupt extends Thread{
	
	public void run() {
		try {
			for(int i=0; i<= 5; i++) {
				System.out.println("I'm Lazy thread");
				Thread.sleep(2000);
			}
		}catch(InterruptedException ie) {
			System.out.println("I got interrupted");
		}
	}
}
