package lab03.ex01_synchwithsem;

public class Pinger extends ActiveComponent {

	public Pinger() {
	}	
	
	public void run() {
		while (true) {
			println("ping");
		}
	}
}