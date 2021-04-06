package thread;

public class RunThread {

	public static void main(String[] args) {

		new HelloThread().start(); // crea y arranca el nuevo hilo
		System.out.println("Hola desde el hilo principal");
		System.out.println("Hilo finalizado");
	}
}
