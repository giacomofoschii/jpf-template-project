package lab03.cswithlocks_jpf;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestCSWithLocks {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		AtomicInteger count = new AtomicInteger(0);
		new MyWorkerB(lock, count).start();
		new MyWorkerA(lock, count).start();
	}
}
