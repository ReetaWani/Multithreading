package io.reeta;

public class ThreadGroupDemo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		
		ThreadGroup g = new ThreadGroup("Reeta");
		System.out.println(g.getParent().getName());
		
		ThreadGroup g1 = new ThreadGroup(g, "Minty");
		System.out.println(g1.getParent().getName());
	}

}
