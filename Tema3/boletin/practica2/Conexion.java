package practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Clase Conexion
 * 
 * Ejecuta el hilo asociado al cliente y trata las peticiones de este
 * 
 * @author Raquel
 *
 */
public class Conexion extends Thread {

	/**
	 * Variable para el buzon personal
	 */
	private Buzon buzon;
	/**
	 * Entrada de datos
	 */
	private DataInputStream dis;
	/**
	 * Salida de datos
	 */
	private DataOutputStream dos;
	/**
	 * Socket para conectar con el cliente
	 */
	private Socket newSocket;
	/**
	 * Variable donde se descargan los datos
	 */
	private String informacion;

	/**
	 * Constructor de la clase Conexion
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
	 * Método run que se ejecuta hasta que no recibe información del cliente y
	 * cierra el socket
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
	 * Método que recibe la información y ejecuta un método u otro en el buzón. Si
	 * la información empieza por #, ejecuta un método que envía un mensaje; si no,
	 * ejecuta otro que lee los mensajes
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
