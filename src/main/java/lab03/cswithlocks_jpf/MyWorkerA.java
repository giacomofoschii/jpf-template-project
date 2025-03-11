package lab03.cswithlocks_jpf;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class MyWorkerA extends Worker {
	
	private Lock lock;
	
	public MyWorkerA(Lock lock, AtomicInteger count){
		super(count);
		this.lock = lock;
	}
	
	public void run(){
		while (true){
		  a1();	
		  try {
			  lock.lockInterruptibly();
			  assert(this.nWorkersInCS.incrementAndGet() == 1);
			  a2();
			  a3();
			  this.nWorkersInCS.decrementAndGet();
		  } catch (InterruptedException ex) {
		  } finally {
			  lock.unlock();
		  }
		}
	}
	
	protected void a1(){
		println("a1");
		// wasteRandomTime(100,500);	
	}
	
	protected void a2(){
		println("a2");
		// wasteRandomTime(300,700);	
	}
	protected void a3(){
		println("a3");
		// wasteRandomTime(300,700);	
	}
}

