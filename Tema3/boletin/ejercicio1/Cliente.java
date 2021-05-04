package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) throws IOException {

		File archivo = new File(".\\boletin\\ejercicio1\\FicheroEmisor.txt");
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);

		try {
			System.out.println("Creando socket cliente");
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
			br.close();
			fr.close();
			clienteSocket.close();

			System.out.println("Mensaje enviado");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
