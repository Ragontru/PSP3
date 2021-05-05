package ejercicio1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {

		FileWriter archivo = new FileWriter(".\\boletin\\ejercicio1\\FicheroReceptor.txt");
		PrintWriter pw = new PrintWriter(archivo);
		BufferedWriter bw = new BufferedWriter(pw);

		try {
			System.out.println("Creando socket servidor");
			ServerSocket server = new ServerSocket();

			System.out.println("Realizando bind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			server.bind(addr);

			System.out.println("Aceptando conexiones");
			Socket newSocket = server.accept();

			System.out.println("Conexión recibida");
			InputStream is = newSocket.getInputStream();
			OutputStream os = newSocket.getOutputStream();

			byte[] mensaje = new byte[25];

			while (is.read(mensaje) > -1) {
				System.out.println("Mensaje recibido: " + new String(mensaje));
				pw.println(new String(mensaje));
				mensaje = new byte[25];
			}

			bw.close();
			pw.close();

			System.out.println("Cerrando el nuevo socket.");
			newSocket.close();
			System.out.println("Cerrando el servidor.");
			server.close();
			System.out.println("Terminando.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
