package io.reeta;

public class ThreadLocalDemo {

	public static void main(String[] args) {
		ThreadLocal tl = new ThreadLocal() {
			public Object initialValue() {
				return "Minty";
			}
		};
		System.out.println(tl.get());
		tl.set("Reeta");
		System.out.println(tl.get());
		tl.remove();
		System.out.println(tl.get());
		
	}

}
