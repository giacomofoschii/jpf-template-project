package lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

/**
 * Synchronized version
 *
 */
public class TestPingPong {
	public static void main(String[] args) {

		Semaphore pingDone = new Semaphore(0);
		Semaphore pongDone = new Semaphore(0);

		new Pinger(pingDone, pongDone).start();
		new Ponger(pingDone, pongDone).start();

		pongDone.release();
	}

}
