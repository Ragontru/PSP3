package practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Conexion extends Thread {

	private Buzon buzon;
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket newSocket;
	private String informacion;

	public Conexion(Socket newSocket, Buzon buzon) {
		this.newSocket = newSocket;
		this.buzon = buzon;

		try {
			this.is = newSocket.getInputStream();
			this.os = newSocket.getOutputStream();
			this.dis = new DataInputStream(is);
			this.dos = new DataOutputStream(os);
		} catch (IOException e) {
			e.printStackTrace();
		}

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

		if (informacion.indexOf("#") != 0) {
			buzon.leerMensaje(informacion);
		} else {
			int pos = informacion.indexOf("#", 1);
			String usuario = informacion.substring(1, pos - 1);
			String mensaje = informacion.substring(pos + 1);
			buzon.enviarMensaje(usuario, mensaje);
		}
	}

}
