package practica2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		Buzon buzon = new Buzon();

		try {
			System.out.println("Creando socket servidor");
			ServerSocket servidor = new ServerSocket();

			System.out.println("Realizando bind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			servidor.bind(addr);

			while (true) {
				Socket newSocket = null;
				try {
					System.out.println("Aceptando conexiones");
					newSocket = servidor.accept();

					System.out.println("Conexión recibida.");
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