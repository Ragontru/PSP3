package ejercicio9;

public class Carrera {

	boolean salida;
	
	public Carrera() {
		this.salida = false;
	}

	
	public synchronized void correr() {
		System.out.println("Doy la salida!");
		try {
			while (!salida) {
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
	}
	
	public synchronized void terminar(int i) {
		System.out.println();
	}
}
