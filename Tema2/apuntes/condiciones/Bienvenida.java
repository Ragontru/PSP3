package condiciones;

public class Bienvenida {

	boolean claseComenzada;

	public Bienvenida() {
		this.claseComenzada = false;
	}

	// Hasta que el profesor no salude no empieza la clase,
	// por lo que los alumnos esperan con un wait
	public synchronized void saludarProfesor() {
		try {
			while (!claseComenzada) { // Mientras sea false
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	// Cuando el profesor saluda avisa a los alumnos con notifyAll de su llegada
	public synchronized void llegadaProfesor(String nombre) {
		System.out.println("Buenos días a todos. Soy el profesor " + nombre);
		this.claseComenzada = true;
		notifyAll();
	}

}
