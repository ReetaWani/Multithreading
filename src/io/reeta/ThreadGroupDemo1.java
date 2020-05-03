package io.reeta;

class MyThread1 extends Thread{
	MyThread1 (ThreadGroup g, String gropuName){
		super(g, gropuName);
	}
	
	public void run( ) {
		System.out.println("Child Thread");
		try {
			Thread.sleep(5000);
		}catch(InterruptedException ie) {}
	}
}

public class ThreadGroupDemo1 {

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup pg = new ThreadGroup("ParentGroup");
		ThreadGroup cg = new ThreadGroup(pg, "ChildGroup");
		MyThread1 t1 = new MyThread1(pg, "ChildThread1");
		MyThread1 t2 = new MyThread1(pg, "ChildThread2");
		
		t1.start();
		t2.start();
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
		pg.list();
		Thread.sleep(10000);
		System.out.println(pg.activeCount());
		System.out.println(pg.activeGroupCount());
		pg.list();
	}

}
