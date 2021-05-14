package practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Conexion extends Thread {

	private Buzon buzon;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket newSocket;
	private String informacion;

	public Conexion(Socket newSocket, Buzon buzon) {
		this.newSocket = newSocket;
		this.buzon = buzon;
	}

	@Override
	public void run() {
		// volcar buffer
		try {
			do {
				informacion = dis.readUTF();
			} while (dis.available() > 0);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// revisar contenido
		// actuar

		if ((informacion.equals("#"))) {

		}
	}

}
