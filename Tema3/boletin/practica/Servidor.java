package practica;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		try {
			System.out.println("Creando socket servidor.");
			ServerSocket servidor = new ServerSocket();

			System.out.println("Realizando bind.");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			servidor.bind(addr);

			while (true) {
				System.out.println("Aceptando conexiones.");
				Socket newSocket = servidor.accept();

				System.out.println("Conexión recibida.");
				Conexion hilo = new Conexion(newSocket);
				hilo.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
