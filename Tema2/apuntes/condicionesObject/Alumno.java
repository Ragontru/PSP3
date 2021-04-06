package condicionesObject;

public class Alumno extends Thread {
	Bienvenida saludo;

	public Alumno(Bienvenida bienvenida) {
		this.saludo = bienvenida;
	}

	@Override
	public void run() {
		System.out.println("Alumno lleg�");
		try {
			Thread.sleep(1000);
			saludo.saludarProfesor();
		} catch (InterruptedException e) {
			System.err.println("Thread alumno interrumpido");
			Thread.currentThread().interrupt();
			System.exit(-1);
		}
	}
}
