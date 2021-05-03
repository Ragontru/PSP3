package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ProgramaA {

	public static String direccion = ".\\boletin\\ejercicio1\\ArchivoEmisor";

	public static void main(String[] args) {

		try {
			File file = new File(direccion);

			FileReader fr;
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			Socket clienteSocket = new Socket();
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);

			clienteSocket.connect(addr);

			InputStream is = clienteSocket.getInputStream();
			OutputStream os = clienteSocket.getOutputStream();
			System.out.println("Enviando mensaje");

			while (br.ready()) {
				String linea = br.readLine();
				System.out.println(linea);
				os.write(linea.getBytes());

			}
			
			os.close();
			
			System.out.println("Mensaje enviado");

		} catch (FileNotFoundException e) {
			System.err.println("No existe el archivo emisor");
		}catch (ConnectException e) {
			System.err.println("No es posible realizar la conexión");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
