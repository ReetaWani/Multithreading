package io.reeta;

public class ThreadByRunnableInterface {

	public static void main(String[] args) {
		
		MyRunnable r = new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		
		System.out.println("In Parent thread");
		//Execution of below code is done by child thread below is the job of thread
		for(int i= 0; i <= 2 ; i++) {
			System.out.println("In Parent thread : "+ i);
		}

	}

}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("In child thread");
		//Execution of below code is done by child thread below is the job of thread
		for(int i= 0; i <= 2 ; i++) {
			System.out.println("In Child thread : "+ i);
		}
		
	}
	
}
