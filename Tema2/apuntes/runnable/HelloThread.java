package runnable;

public class HelloThread implements Runnable {

	Thread t;

	public HelloThread() {
		t = new Thread(this, "Nuevo thread");
		System.out.println("Creado hilo: " + t);
		t.start(); // arranca el nuevo hilo de ejecuci�n y ejecuta el m�todo run
	}

	@Override
	public void run() {
		System.out.println("Hola desde el hilo creado!");
		System.out.println("Hilo finalizado");
	}

}
