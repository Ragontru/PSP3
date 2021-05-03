package datagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EmisorDatagramSocket {

	public static void main(String[] args) {

		try {
			System.out.println("Creando socket datagram");
			DatagramSocket socket = new DatagramSocket();

			System.out.println("Enviando mensaje");
			String mensaje = "Mensaje desde el emisor";

			InetAddress addr = InetAddress.getByName("localhost");
			DatagramPacket datagram = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, addr, 5555);
			socket.send(datagram);
			System.out.println("Mensaje enviado");
			
			System.out.println("Cerrando socket datagram");
			socket.close();
			
			System.out.println("Terminado");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
