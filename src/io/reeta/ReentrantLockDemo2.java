package io.reeta;

import java.util.concurrent.locks.ReentrantLock;

class Display {
	
	ReentrantLock l = new ReentrantLock();
	public void wish(String name) {
		l.lock();
		for(int i =0; i<=10; i++) {
			System.out.print("Good Morning : ");
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {
			}
			System.out.println(name);
		}
		l.unlock();
	}
}

class MyThreadDisplay extends Thread {
	Display d;
	String name;
	MyThreadDisplay(Display d, String name) {
		this.d = d;
		this.name = name;
	}
	public void run() {
		d.wish(name);
	}
}

public class ReentrantLockDemo2 {

	public static void main(String[] args) {
		Display d = new Display();
		MyThreadDisplay t1 = new MyThreadDisplay(d, "Reeta");
		MyThreadDisplay t2 = new MyThreadDisplay(d, "Minty");
		t1.start();
		t2.start();
	}

}
