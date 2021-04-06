package runnable;

public class RunThread {

	public static void main(String[] args) {

		new HelloThread(); // crea un nuevo hilo de ejecución
		System.out.println("Hola desde el hilo principal");
		System.out.println("Proceso acabado");
	}
}
