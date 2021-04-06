package condicionesObject;

public class Profesor extends Thread {

	String nombre;
	Bienvenida saludo;

	public Profesor(String nombre, Bienvenida bienvenida) {
		this.nombre = nombre;
		this.saludo = bienvenida;
	}

	@Override
	public void run() {
		System.out.println(nombre + " lleg�");
		try {
			Thread.sleep(1000);
			saludo.llegadaProfesor(nombre);
		} catch (InterruptedException e) {
			System.err.println("Thread profesor interrumpido");
			Thread.currentThread().interrupt();
			System.exit(-1);
		}
	}
}
