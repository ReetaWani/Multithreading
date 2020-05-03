package io.reeta;

class ParentThread extends Thread{
	public static InheritableThreadLocal tl = new InheritableThreadLocal() {
		public Object childValue(Object p) {
			return "cc";
		}
	};
	
	public void run() {
		tl.set("pp");
		System.out.println("Parent thread value =:"+tl.get());
		ChildThread cl = new ChildThread();
		cl.start();
	}
}

class ChildThread extends Thread{
	
	public void run() {
		System.out.println("Child thread value :="+ParentThread.tl.get());
	}
	
}

public class InheritableThreadLocalDemo {

	public static void main(String[] args) {
		ParentThread pp = new ParentThread();
		pp.start();

	}

}
