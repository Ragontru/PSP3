package practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Conexion extends Thread {

	private Buzon buzon;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket newSocket;

	public Conexion(Socket newSocket, Buzon buzon) {
		this.newSocket = newSocket;
		this.buzon = buzon;
		
	}

}
