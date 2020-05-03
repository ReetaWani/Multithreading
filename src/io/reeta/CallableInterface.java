package io.reeta;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class PrintJob1 implements Callable{
	int num ;
	PrintJob1(int num){
		this.num = num;
	}
	
	public Object call() throws Exception {
		System.out.println(Thread.currentThread().getName()+" :is executing sum of :"+num);
		int sum = 0;
		//for(int i = 1; i<=num; i++) {
			sum = num*(num+1)/2; // 10*(10+1)/2
		//}
		return sum;
	}
	
}

public class CallableInterface {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		PrintJob1 [] jobs = {
				new PrintJob1(10),
				new PrintJob1(20),
				new PrintJob1(30)
		};
		ExecutorService service = Executors.newFixedThreadPool(2);
		for(PrintJob1 job : jobs) {
			Future f = service.submit(job);
			System.out.println(f.get());
		}
		service.shutdown();
	}

}
