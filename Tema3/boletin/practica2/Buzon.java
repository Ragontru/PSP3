package practica2;

import java.util.ArrayList;
import java.util.HashMap;

public class Buzon {

	private static HashMap<String, ArrayList<String>> buzon = new HashMap<>();

	// TODO
	public synchronized static boolean enviarMensaje(String mensaje) {

		boolean enviado = false;

		return enviado;

	}

	public synchronized static boolean leerMensaje() {

		boolean leido = false;

		return leido;

	}

}
