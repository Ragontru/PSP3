package ejercicio2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String mensaje;
		byte[] mensajes = new byte[25];

		try {
			System.out.println("Creando socket cliente");
			Socket clienteSocket = new Socket();
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os = clienteSocket.getOutputStream();

			System.out.println("Enviando mensaje");

			do {
				mensaje = teclado.nextLine();
				os.write(mensaje.getBytes());
				is.read(mensajes);
				System.out.println("Mensaje recibido: " + new String(mensajes));
				mensajes = new byte[25];

			} while (!mensaje.equalsIgnoreCase("cerrar"));

			os.close();
			clienteSocket.close();
			System.out.println("Cerrando");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
