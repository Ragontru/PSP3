package practica2;

import java.net.Socket;

public class Conexion extends Thread {

	private Socket newSocket;

	public Conexion(Socket newSocket, Buzon buzon) {
		this.newSocket = newSocket;
		
	}

}
