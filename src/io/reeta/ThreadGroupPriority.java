package io.reeta;

public class ThreadGroupPriority {

	public static void main(String[] args) {
		ThreadGroup g = new ThreadGroup("tg");
		Thread t1 = new Thread(g, "FirstThread");
		Thread t2 = new Thread(g, "SecondThread");
		g.setMaxPriority(3);
		Thread t3 = new Thread(g,"ThirdThread");
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
	}

}
