package ejercicio2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {

		try {
			System.out.println("Creando socket servidor");
			ServerSocket server = new ServerSocket();

			System.out.println("Realizando blind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			server.bind(addr);

			System.out.println("Aceptando conexiones");
			Socket newSocket = server.accept();

			System.out.println("Conexi�n recibida");
			InputStream is = newSocket.getInputStream();
			OutputStream os = newSocket.getOutputStream();
			byte[] mensaje = new byte[25];

			while (dev.compareTo("cerrar" != 0)) {
//				if (is.read(message) > -1) {
				message = new byte[35];
				is.read(message);
				String linea = new String(message);
				System.out.println(linea.length() + ".");
				if (pregunta.trim().equalsIgnoreCase("salir")) {
					salida = true;
				} else {
					for (int i = 0; i < linea.length(); i++) {
//						String v = " ";
//						os.write(v.getBytes());
						if (linea.charAt(i) == '?') {

							System.out.println("Pregunta finalizada");
							System.out.println(pregunta);
							i = linea.length();
							String vuelta;
							String preguntaBuena = pregunta.trim();
							//
							switch (preguntaBuena) {
							case "�C�mo te llamas":
								vuelta = "Me llamo Ejercicio 2".trim();
								os.write(vuelta.getBytes());
								break;
							case "�Cu�ntas l�neas de c�digo tienes":
								vuelta = "pfff muchas no se";
								os.write(vuelta.getBytes());
								break;
							default:
								System.out.println(preguntaBuena + ".");
								vuelta = "No entendi";
								os.write(vuelta.getBytes());

							}
							pregunta = "";
						} else {

							pregunta = pregunta.concat(linea.charAt(i) + "");
							System.out.println(pregunta);
						}
					}
				}
				os.write(0);
				os.flush();
//				}else {
//					salida = true;
//				}

			}
			System.out.println("Cerrando el nuevo socket");
			newSocket.close();

			System.out.println("Cerrando el socket servidor");
			server.close();
			System.out.println("Terminado");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
