package practica2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase Buzon
 * 
 * Permite el control del buzón personal
 * 
 * @author Raquel
 *
 */
public class Buzon {

	/**
	 * 
	 */
	private HashMap<String, ArrayList<String>> buzon = new HashMap<>();

	/**
	 * Recoge los mensajes del receptor en un arraylist auxiliar; en caso de no
	 * existir, devuelve null e inicializa el arraylist auxiliar. Añade el nuevo
	 * mensaje al final del arraylist auxiliar y seguidamente lo incluye en el
	 * HashMap con el nombre de usuario
	 * 
	 * @param usuario Key del HashMap, corresponde al nombre del receptor del
	 *                mensaje
	 * @param mensaje Nuevo mensaje a incluir en el buzón del receptor
	 */
	public synchronized void enviarMensaje(String usuario, String mensaje) {

		ArrayList<String> aux;
		aux = buzon.get(usuario);

		if (aux == null) {
			aux = new ArrayList<>();
		}

		aux.add(mensaje);
		buzon.put(usuario, aux);

	}

	/**
	 * Recibe el nombre del usuario y devuelve una cadena donde se encuentran todos
	 * los mensajes del usuario. En caso de no hubiese mensajes, devuelve la
	 * información de que no contiene mensajes nuevos
	 * 
	 * @param usuario Key del HashMap, corresponde al nombre del propietario del
	 *                buzón
	 * @return una cadena que contiene los mensajes en caso de haberlos y , si no,
	 *         un mensaje informativo de que no hay mensajes
	 */
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
