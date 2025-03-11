package lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Ponger extends ActiveComponent {

	private final Semaphore pingDone, pongDone;

	public Ponger(Semaphore pingDone, Semaphore pongDone) {
		this.pingDone = pingDone;
		this.pongDone = pongDone;
	}	
	
	public void run() {
		while (true) {
			try {
				pingDone.acquire();
				println("pong");
				pongDone.release();
			} catch (Exception ex) {}
		}
	}
}