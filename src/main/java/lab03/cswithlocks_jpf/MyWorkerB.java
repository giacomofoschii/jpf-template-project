package lab03.cswithlocks_jpf;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class MyWorkerB extends Worker {
	
	private Lock lock;
	
	public MyWorkerB(Lock lock, AtomicInteger count){
		super(count);
		this.lock = lock;
	}

	public void run(){
		while (true){
		  try {
			  lock.lockInterruptibly();
			  assert(this.nWorkersInCS.incrementAndGet() == 1);
			  b1();
			  b2();
			  this.nWorkersInCS.decrementAndGet();
		  } catch (InterruptedException ex) {
		  } finally {
			  lock.unlock();
		  }
		  b3();
		}
	}
	
	protected void b1(){
		println("b1");
		// wasteRandomTime(0,1000);	
	}
	
	protected void b2(){
		println("b2");
		// wasteRandomTime(100,200);	
	}
	protected void b3(){
		println("b3");
		// wasteRandomTime(1000,2000);	
	}
}
