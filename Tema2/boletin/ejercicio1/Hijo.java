package ejercicio1;

public class Hijo implements Runnable {

	Thread hilo;
	private int n;

	public Hijo(int N) {
		this.n = N;
		hilo = new Thread(this, "Nuevo hilo");
		System.out.println("Hijo creado: " + hilo);
		hilo.start();
	}

	@Override
	public void run() {
		System.out.println("\nRun del hijo " + n);
		for (int i = 1; i < this.n + 1; i++) {
			System.out.println(fibonacci(i));
		}
		System.out.println("Hijo acabado\n");

	}

	private int fibonacci(int n) {
		if (n > 1) {
			return fibonacci(n - 1) + fibonacci(n - 2);
		} else if (n == 1) {
			return 1;
		} else if (n == 0) {
			return 0;
		} else {
			System.out.println("El número debe ser positivo");
			return -1;
		}
	}

}
