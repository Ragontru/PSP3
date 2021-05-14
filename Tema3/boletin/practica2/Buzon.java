package practica2;

import java.util.ArrayList;
import java.util.HashMap;

public class Buzon {

	private HashMap<String, ArrayList<String>> buzon = new HashMap<>();

	// TODO
	public synchronized void enviarMensaje(String usuario, String mensaje) {

		ArrayList<String> aux;
		aux = buzon.get(usuario);

		if (aux == null) {
			aux = new ArrayList<>();
		}

		aux.add(mensaje);
		buzon.put(usuario, aux);

	}

	// TODO
	public synchronized void leerMensaje(String usuario) {

		ArrayList<String> aux;
		aux = buzon.get(usuario);

		if (aux == null) {
			System.out.println("No hay mensajes nuevos");
		} else {
			while (!buzon.isEmpty()) {

			}
		}

	}

}
