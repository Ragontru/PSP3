package practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 
 * @author Raquel
 *
 */
public class Conexion extends Thread {

	/**
	 * 
	 */
	private Buzon buzon;
	/**
	 * 
	 */
	private DataInputStream dis;
	/**
	 * 
	 */
	private DataOutputStream dos;
	/**
	 * 
	 */
	private Socket newSocket;
	/**
	 * 
	 */
	private String informacion;
	/**
	 * 
	 */
	private String contenido;

	/**
	 * 
	 * @param newSocket
	 * @param buzon
	 */
	public Conexion(Socket newSocket, Buzon buzon) {
		this.newSocket = newSocket;
		this.buzon = buzon;

		try {
			this.dis = new DataInputStream(newSocket.getInputStream());
			this.dos = new DataOutputStream(newSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	@Override
	public void run() {
		// volcar buffer

		boolean salir = false;

		while (salir != true) {

			try {
				informacion = dis.readUTF();
				iniciar(informacion);
			} catch (IOException e) {
				try {
					salir = true;
					newSocket.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

		}

	}

	/**
	 * 
	 * @param informacion
	 */
	private void iniciar(String informacion) {

		// revisar contenido
		// actuar
		if (informacion.indexOf("#") != 0) {
			try {
				dos.writeUTF(buzon.leerMensaje(informacion));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			int pos = informacion.indexOf("#", 1);
			String usuario = informacion.substring(1, pos);
			String mensaje = informacion.substring(pos + 1);
			try {
				buzon.enviarMensaje(usuario, mensaje);
				dos.writeUTF("Mensaje enviado al usuario " + usuario);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
