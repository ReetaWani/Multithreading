package io.reeta;

// Here there are two thread one is Main thread which instantiate a child thread of MyThread.
public class ThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("This is test");
		MyThread thread = new MyThread();  // Thread initialization
		thread.start(); // Thread starting
		
		//thread.join();
		thread.join(1000); // wait for other thread to complete then starts own execution 
		
		//Execution of below code is done by main thread
		for(int i= 0; i <= 2 ; i++) {
			System.out.println("In Parent thread : "+ i);
		}
	}
}
class MyThread extends Thread{
	public void run() {
		System.out.println("In child thread");
		//Execution of below code is done by child thread below is the job of thread
		for(int i= 0; i <= 2 ; i++) {
			System.out.println("In Child thread : "+ i);
			Thread.yield(); // this gives chance to other threads to execute and self goes into thread scheduler queue
			try {
				Thread.sleep(2000); // thread pause its own execution for give time and then starts itself.
			}
			catch(InterruptedException ie) {
				
			}
		}
	}
}

