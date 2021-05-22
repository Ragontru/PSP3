package practica2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * BUZÓN DE MENSAJES 
 * Práctica entregable del tema 3 de PSP: Programación de
 * comunicaciones en red
 * 
 * Clase Servidor 
 * 
 * Se encarga de iniciar el servidor, recibe las solicitudes y
 * crea tantos hilos como van llegando los usuarios a conectarse
 * Debe iniciarse la primera
 * 
 * @author Raquel
 *
 */
public class Servidor {

	public static void main(String[] args) {

		/**
		 * 
		 */
		Buzon buzon = new Buzon();

		try {
			System.out.println("Creando socket servidor");
			/**
			 * 
			 */
			ServerSocket servidor = new ServerSocket();

			System.out.println("Realizando bind");
			/**
			 * 
			 */
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			servidor.bind(addr);

			while (true) {
				/**
				 * 
				 */
				Socket newSocket = null;
				try {
					System.out.println("Aceptando conexiones");
					newSocket = servidor.accept();

					System.out.println("Conexión recibida.");
					/**
					 * 
					 */
					Conexion hilo = new Conexion(newSocket, buzon);
					hilo.start();

				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}