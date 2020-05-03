package io.reeta;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable{
	String name ;
	PrintJob(String name){
		this.name = name;
	}
	public void run() {
		System.out.println(name +"This is executed by :"+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e){	}
		System.out.println(name +"This job is finihsed by :"+Thread.currentThread().getName());
	}
	
}
public class ThreadPoolDemo {

	
	public static void main(String[] args) {
		PrintJob [] jobs = {
				new PrintJob("Reeta"),
				new PrintJob("Minty"),
				new PrintJob("Sweety")
		};
		ExecutorService service = Executors.newFixedThreadPool(2);
		for(PrintJob job : jobs) {
			service.submit(job);
		}
		service.shutdown();
	}

}
