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

	public static void main(String[] args) {

		try {
			System.out.println("Creando socket cliente");
			Socket clienteSocket = new Socket();
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			Scanner teclado = new Scanner(System.in);
			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os = clienteSocket.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			String escribe;

			while (true) {
				do {
					String lee = dis.readUTF();
					System.out.println(lee);
				} while (dis.available() > 0);

				escribe = teclado.nextLine();
				dos.writeUTF(escribe);

				if (escribe.equals("0")) {
					System.out.println("Cliente cerrado");
					clienteSocket.close();
					break;
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
