package metodoSincronizado;

public class Contador {

	private int c = 0;

	public void Contador(int num) {
		this.c = num;
	}

	public synchronized void increment() {
		c++;
	}

	public synchronized void decrement() {
		c--;
	}

	public synchronized int value() {
		return c;
	}

}
