package io.reeta;

public class SystemGroupDetail {

	public static void main(String[] args) {
		ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
		Thread[] threadList = new Thread[system.activeCount()];
		system.enumerate(threadList);
		for(Thread t : threadList) {
			System.out.println(t.getName()+"--"+t.isDaemon());
		}
	}

}
