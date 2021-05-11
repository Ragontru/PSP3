package practica;

import java.util.ArrayList;

public class Buzon {

	private static ArrayList<Correo> buzon = new ArrayList<Correo>();

	public synchronized static boolean borrarMensaje(String mensaje) {

		boolean borrado = false;

		try {
			buzon.remove(mensaje);
			borrado = true;
		} catch (Exception e) {
			System.err.println("No se ha podido eliminar el mensaje");
			return borrado;
		}

		return borrado;
	}

	public synchronized static ArrayList<Correo> buscarMensajes(String usuario) {
		ArrayList<Correo> correos = new ArrayList<>();
		for (Correo c : correos) {
			if (c.getReceptor().equals(usuario.trim())) {
				correos.add(c);
			}
		}
		return correos;

	}

	public synchronized static boolean enviarMensaje(Correo correo) {

		boolean enviado = false;

		try {
			buzon.add(correo);
			enviado = true;
		} catch (Exception e) {
			System.err.println("No se ha podido enviar el mensaje");
		}

		return enviado;

	}

}
