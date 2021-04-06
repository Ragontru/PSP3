package interrupcion;

public class Sleep {

	int datos = 7;

	public void run() {
		for (int i = 0; i < datos; i++) {
			try {
				System.out.println("Esperando a recibir dato!");
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Hilo interrumpido");
				return;
			}

			// Gestiona dato int
		}
		System.out.println("Hilo finalizado correctamente");
	}

}
