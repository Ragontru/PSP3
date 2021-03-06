package practica2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Clase Cliente
 * 
 * Se encarga de crear el socket del cliente, conectarlo con el servidor y
 * mostrarle al usuario las diferentes funciones seguido de su respuesta
 * Debe iniciarse despu?s de la clase Servidor
 * 
 * @author Raquel
 *
 */
public class Cliente {

	public static void main(String[] args) {

		try {
			System.out.println("Creando socket cliente");
			Socket clienteSocket = new Socket();
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os = clienteSocket.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			Scanner teclado = new Scanner(System.in);
			
			/**
			 * Variable para el usuario
			 */
			String usuario;
			/**
			 * Variable para el receptor
			 */
			String receptor;
			/**
			 * Variable para el mensaje
			 */
			String mensaje;
			/**
			 * Variable para almacenar el emisor y el mensaje con el protocolo establecido
			 */
			String protocolo;
			/**
			 * Varible para la opci?n seleccionada por el usuario
			 */
			String opcion = "inicio";

			System.out.println("Introduce el nombre de usuario: ");
			usuario = teclado.nextLine();
			System.out.println("El usuario '" + usuario + "' ha iniciado sesi?n.");

			while (!opcion.equals("0")) {

				System.out.println("\n --- ?Qu? desea hacer? ---");
				System.out.println("\n 1. Revisar buz?n");
				System.out.println("\n 2. Escribir correo");
				System.out.println("\n 0. Salir");

				opcion = teclado.nextLine();

				switch (opcion) {
				case "0":
					System.out.println("Cliente cerrado");
					break;
				case "1":
					// Revisar buz?n
					// conexion y buzon
					dos.writeUTF(usuario);
					break;
				case "2":
					// Escribir mensaje
					// conexion y buzon
					System.out.println("?A qui?n quieres enviarle un correo?");
					receptor = teclado.nextLine();
					System.out.println("Qu? mensaje quieres enviarle?");
					mensaje = teclado.nextLine();
					protocolo = "#" + receptor + "#" + usuario + ":" + mensaje;
					dos.writeUTF(protocolo);
					break;
				default:
					System.out.println("Opci?n no disponible");
					break;
				}

				if ((opcion.equals("1")) || (opcion.equals("2"))) {
					do {
						String lee = dis.readUTF();
						System.out.println(lee);
					} while (dis.available() > 0);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
