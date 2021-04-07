package ejercicio2;

public class Hijo extends Thread {

	String nombre;

	public Hijo(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}

			if (count == 1000) {
				count = 0;
			}

			System.out.println(nombre + " : " + count++);

		}
	}
}
