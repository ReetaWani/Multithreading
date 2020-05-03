package io.reeta;

public class DaemonThreadDemo {

	public static void main(String[] args) {
		
		MyDaemonThread t = new MyDaemonThread();
		//t.setDaemon(true);
		t.start();
		System.out.println("End of Main method thread");
	}

}

class MyDaemonThread extends Thread{
	
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("In Child thread");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}