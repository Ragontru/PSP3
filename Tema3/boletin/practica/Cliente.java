package practica;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	private static Scanner teclado = new Scanner(System.in);
	private static DataInputStream entrada;
	private static DataOutputStream salida;
	
	public static void main(String[] args) {

		try {
			System.out.println("Creando socket cliente");
			Socket clienteSocket = new Socket();
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os = clienteSocket.getOutputStream();

			System.out.println("Introduce el nombre de usuario: ");
			String nombre = teclado.next();
			System.out.println("El usuario '"+nombre+"' ha iniciado sesión.");
			
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
