package lab03.ex01_synchwithsem;

import java.util.concurrent.Semaphore;

public class Pinger extends ActiveComponent {

	private final Semaphore pingDone, pongDone;

	public Pinger(Semaphore pingDone, Semaphore pongDone) {
		this.pingDone = pingDone;
		this.pongDone = pongDone;
	}

	public void run() {
		while (true) {
			try {
				pongDone.acquire();
				println("ping");
				pingDone.release();
			} catch (Exception ex) {
			}
		}
	}
}