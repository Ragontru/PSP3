package ejercicio9;

public class Corredor extends Thread {

	Carrera carrera;
	int i;

	public Corredor(Carrera carrera, int i) {
		this.carrera = carrera;
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println("Soy el corredor " + this.i + ", corriendo . . .");
		try {
			Thread.sleep(2000);
			carrera.correr();
			carrera.terminar(i);
		} catch (InterruptedException e) {
			System.err.println("Thread corredor " + this.i + " interrumpido");
			Thread.currentThread().interrupt();
			System.exit(-1);
		}
	}
}