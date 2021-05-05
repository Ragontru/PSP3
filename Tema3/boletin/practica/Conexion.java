package practica;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Conexion extends Thread {

	private Socket newSocket;
	private ArrayList<Buzon> mensajes;

	public Conexion(Socket newSocket) {
		this.newSocket = newSocket;
		this.mensajes = new ArrayList<Buzon>();
	}

	@Override
	public void run() {
		// try {
		System.out.println("Prueba desde Conexión");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

}
