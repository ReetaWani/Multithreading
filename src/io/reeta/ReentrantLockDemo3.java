package io.reeta;

import java.util.concurrent.locks.ReentrantLock;

class MyThread4 extends Thread{
	ReentrantLock l = new ReentrantLock();
	
	public void run() {
		if(l.tryLock()) {
			System.out.println(Thread.currentThread().getName()+" performs safe operation");
			l.lock();
			try {
				Thread.sleep(4000);
			}catch (InterruptedException e) {
			}
			l.unlock();
		}else {
			System.out.println(Thread.currentThread().getName()+" performs alternate operation");
		}
	}
}

public class ReentrantLockDemo3 {

	public static void main(String[] args) {
		MyThread4 t1 = new MyThread4();
		MyThread4 t2 = new MyThread4();
		t1.start();
		t2.start();
		
	}

}
