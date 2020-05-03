package io.reeta;

class A{
	
	public synchronized void d1(B b) throws InterruptedException{
		System.out.println("Inside d1 method of A class");
		Thread.sleep(6000);
		System.out.println("A thread invoking last method of class B");
		b.last();
	}
	
	public synchronized void last() {
		System.out.println("In last method of A class");
	}
}

class B{
	
	public synchronized void d2(A a) throws InterruptedException{
		System.out.println("Inside d2 method of B class");
		Thread.sleep(6000);
		System.out.println("B thread invoking last method of class A");
		a.last();
	}
	
	public synchronized void last() {
		System.out.println("In last method of B class");
	}
}

public class DeadlockDemo extends Thread{
	A a = new A();
	B b = new B();
	 public void m1() throws InterruptedException {
		 this.start();
		 a.d1(b);
	 }
	
	public void run() {
		try {
			b.d2(a);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DeadlockDemo demo = new DeadlockDemo();
		try {
			demo.m1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
