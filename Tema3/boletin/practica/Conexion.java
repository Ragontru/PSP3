package practica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Conexion extends Thread {

	private DataInputStream dis;
	private DataOutputStream dos;
	private Socket newSocket;

	private String usuario;
	private ArrayList<Correo> correos;

	private boolean cerrar = false;
	private String emisor;
	private String receptor;
	private String mensaje;

	public Conexion(Socket newSocket, DataInputStream dis, DataOutputStream dos, Buzon buzon) {
		this.newSocket = newSocket;
		this.dis = dis;
		this.dos = dos;
	}

	@Override
	public void run() {

		try {
			dos.writeUTF("Introduce el nombre de usuario: ");
			this.usuario = this.dis.readUTF();
			dos.writeUTF("\n --- El usuario '" + this.usuario + "' ha iniciado sesión. ---\n");

			while (!cerrar) {
				muestraMenu();
				emisor = dis.readUTF();
				getOpcion(emisor);
			}

		} catch (NumberFormatException e) {
			try {
				dos.writeUTF("Inserta un número");
			} catch (IOException ex) {	
				ex.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void getOpcion(String opc) {
		int opcion = Integer.parseInt(opc);

		switch (opcion) {
		case 0:
			try {
				dos.writeUTF("0");
				newSocket.close();
				cerrar = true;

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 1:
			revisaBuzon();
			break;
		case 2:
			escribeCorreo();
			break;

		default:
			try {
				dos.writeUTF("Opción no disponible");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		}

	}

	private void muestraMenu() {
		try {
			dos.writeUTF("\n --- ¿Qué desea hacer? ---");
			dos.writeUTF("\n 1. Revisar buzón");
			dos.writeUTF("\n 2. Escribir correo");
			dos.writeUTF("\n 0. Salir");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void escribeCorreo() {
		try {
			dos.writeUTF("¿A quién quieres enviarle un correo?");
			receptor = dis.readUTF();
			dos.writeUTF("¿Qué mensaje quieres enviarle?");
			mensaje = dis.readUTF();
			Correo correo = new Correo(receptor, this.usuario, mensaje);
			Buzon.enviarMensaje(correo);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void revisaBuzon() {
		this.correos = Buzon.buscarMensajes(usuario);
		if (!correos.isEmpty()) {
			leerMensajes(correos);
		} else {
			try {
				dos.writeUTF("No hay nuevos correos.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void leerMensajes(ArrayList<Correo> correos) {
		while (!correos.isEmpty()) {
			Correo c = correos.get(0);
			try {
				dos.writeUTF("Hay " + correos.size() + " correos por leer");
				dos.writeUTF(c.toString());
				Buzon.borrarMensaje(c.getMensaje());
				this.correos.remove(c);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			dos.writeUTF("Ya no hay más mensajes");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
