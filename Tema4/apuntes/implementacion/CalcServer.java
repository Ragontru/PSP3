package implementacion;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class CalcServer extends Thread {

	private Socket clientSocket;

	public CalcServer(Socket s) {
		clientSocket = s;
	}

	@Override
	public void run() {
		try {
			System.out.println("INFO: Arrancando hilo ...");

			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();

			System.out.println("INFO: Esperando mensaje de operación");

			byte[] buffer = new byte[1];
			is.read(buffer);
			String op = new String(buffer);

			System.out.println("INFO: Operación recibida: " + op);

			if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
				System.out.println("INFO: Esperando primer operador");

				int op1 = is.read();
				System.out.println("INFO: Primer operador: " + op1);

				System.out.println("INFO: Esperando segundo operador");

				int op2 = is.read();
				System.out.println("INFO: Segundo operador: " + op2);

				System.out.println("INFO: Calculando resultado ... ");

				int result = Integer.MIN_VALUE;

				switch (op) {
				case "+":
					result = op1 + op2;
					break;
				case "-":
					result = op1 - op2;
					break;
				case "*":
					result = op1 * op2;
					break;
				case "/":
					result = op1 / op2;
					break;
				}

				System.out.println("INFO: Enviando resultado");
				os.write(result);
			} else {
				System.out.println("INFO: Operación no reconocida");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("INFO: Hilo terminado");
	}
}
