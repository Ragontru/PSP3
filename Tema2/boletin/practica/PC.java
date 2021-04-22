package practica;

import java.util.Random;

/**
 * Clase PC (Recurso compartido con los hilos Persona).
 * 
 * 
 * 
 * @author Raquel
 *
 */
public class PC {

	/**
	 * Variable para generar un tiempo aleatorio
	 */
	private Random tiempo = new Random();
	/**
	 * Indica si el ordenador está libre o no. Si su valor es true, está libre.
	 */
	private boolean libre = true;

	/**
	 * Constructor de la clase PC
	 */
	public PC() {
		
	}

	/**
	 * Monitor para coger el PC. En caso de que no consiga cogerlo en el tiempo
	 * dado, volvería al estado de pensar
	 * 
	 * @param idPersona ID de la persona
	 * @return Si devuelve true, continúa el proceso de uso porque tendría las dos
	 *         tarjetas y el PC; si devuelve false, volvería a pensar
	 * @throws InterruptedException
	 */
	public synchronized boolean cogerPC(int idPersona) throws InterruptedException {
		while (!libre) {
			this.wait(tiempo.nextInt(5000) + 2000);
			return false;
		}

		System.out.println("La persona " + idPersona + " coge el ordenador.");
		libre = false;
		return true;
	}

	/**
	 * Monitor para soltar el PC y volver a pensar
	 * 
	 * @param idPersona ID de la persona
	 * @throws InterruptedException
	 */
	public synchronized void soltarPC(int idPersona) throws InterruptedException {

		libre = true;
		System.out.println("La persona " + idPersona + " deja de usar el ordenador.");
		this.notify();
	}
}
