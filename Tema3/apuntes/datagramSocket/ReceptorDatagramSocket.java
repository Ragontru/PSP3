package datagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class ReceptorDatagramSocket {

	public static void main(String[] args) {

		try {
			System.out.println("Creando socket datagram");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			DatagramSocket socket = new DatagramSocket(addr);

			System.out.println("Recibiendo el mensaje");
			byte[] mensaje = new byte[25];
			DatagramPacket datagram1 = new DatagramPacket(mensaje, 25);
			socket.receive(datagram1);

			System.out.println("Mensaje enviado");

			System.out.println("Cerrando el socket datagram");
			socket.close();

			System.out.println("Terminado");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
