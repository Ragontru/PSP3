package implementacion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class CalcClient {

	public static void main(String[] args) {
		try {
			System.out.println("INFO: Creando socket cliente");
			Socket clientSocket = new Socket();

			System.out.println("INFO: Estableciendo conexión");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			clientSocket.connect(addr);

			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();

			System.out.println("INFO: Enviando petición de suma");
			os.write("*".getBytes());

			System.out.println("INFO: Enviando primer operando");
			os.write(59);

			System.out.println("INFO: Enviando segundo operando");
			os.write(130);

			System.out.println("INFO: Recibiendo resultado");
			int result = is.read();
			System.out.println("INFO: Resultado de la suma: " + result);

			System.out.println("INFO: Cerrando socket cliente");
			clientSocket.close();

			System.out.println("INFO: Cliente terminado");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
