package ejercicio9;

public class Corredor extends Thread {

	private Carrera carrera;
	private int i;

	public Corredor(Carrera carrera, int i) {
		this.carrera = carrera;
		this.i = i;
	}

	@Override
	public void run() {
		try {
			relevar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		terminar();
	}

	public synchronized void relevar() throws InterruptedException {
		carrera.correr(i);
		System.out.println("Soy el corredor " + this.i + ", corriendo . . .");
	}

	public synchronized void terminar() {
		System.out.println("Terminé. Pasando el relevo al hijo " + i);
		carrera.terminar();
	}
}
