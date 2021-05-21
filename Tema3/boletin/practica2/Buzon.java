package practica2;

import java.util.ArrayList;
import java.util.HashMap;

public class Buzon {

	private HashMap<String, ArrayList<String>> buzon = new HashMap<>();

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
	public synchronized String leerMensaje(String usuario) {

		ArrayList<String> aux = buzon.get(usuario);
		String ultimo;
		String mensajes = "";

		if (aux == null) {
			return "No hay mensajes nuevos";
		} else {
			for (int i = 0; i < aux.size(); i++) {
				ultimo = aux.get(i) + " // ";
				mensajes = mensajes + ultimo;
			}
			buzon.remove(usuario);
			return mensajes;
		}

	}

}
