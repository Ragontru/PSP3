package ejercicio9;

public class Carrera {

	private boolean salida;
	private int relevo = 1;

	public Carrera() {
		salida = false;
	}

	public synchronized void correr(int nCorredor) throws InterruptedException {
		while (salida || nCorredor != relevo) {
			wait();
		}

		salida = true;

	}

	public synchronized void terminar() {
		relevo++;
		salida = false;
		notifyAll();
	}
}
