package practica;

import java.net.Socket;

public class Conexion extends Thread {

	private Socket newSocket;

	public Conexion(Socket newSocket) {
		this.newSocket = newSocket;
	}

	@Override
	public void run() {

	}

}
