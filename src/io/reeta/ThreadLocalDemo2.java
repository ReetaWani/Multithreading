package io.reeta;

class CustomerThread1 extends Thread{
	static Integer customerId = 0;
	private static ThreadLocal tl = new ThreadLocal() {
		protected Integer initialValue() {
			return ++customerId;
		}
	};
	
	CustomerThread1(String name){
		super(name);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" executing with customerId :"+tl.get());
	}
}
public class ThreadLocalDemo2 {

	public static void main(String[] args) {
		CustomerThread1 c1 = new CustomerThread1("Customer Thread-1");
		CustomerThread1 c2 = new CustomerThread1("Customer Thread-2");
		CustomerThread1 c3 = new CustomerThread1("Customer Thread-3");
		CustomerThread1 c4 = new CustomerThread1("Customer Thread-4");
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}
}
