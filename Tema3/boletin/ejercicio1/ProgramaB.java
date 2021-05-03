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

public class ProgramaB {

	public static String direccion = ".\\boletin\\ejercicio1\\ArchivoReceptor";

	public static void main(String[] args) {
		
		try {

			System.out.println("Creando socket servidor");
			ServerSocket server = new ServerSocket();

			System.out.println("Realizando blind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			server.bind(addr);

			System.out.println("Aceptando conexiones");
			Socket newSocket = server.accept();

			System.out.println("Conexión recibida");
			InputStream is = newSocket.getInputStream();
			OutputStream os = newSocket.getOutputStream();

			FileWriter fw = new FileWriter(direccion);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			byte[] mensaje = new byte[25];

			while (is.read(mensaje) > -1) {
				System.out.println("Mensaje recibido: " + new String(mensaje));
				out.println(new String(mensaje));
			}
			out.close();
			bw.close();
			fw.close();

			System.out.println("Cerrando el nuevo socket");
			newSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
