package lab03.cswithlocks_jpf;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Worker extends Thread {
	protected AtomicInteger nWorkersInCS;
		
	public Worker(AtomicInteger count) {
		this.nWorkersInCS = count;
	}

	protected void print(String msg){
		synchronized (System.out){
			System.out.print(msg);
		}
	}

	protected void println(String msg){
		synchronized (System.out){
			System.out.println(msg);
		}
	}
}
