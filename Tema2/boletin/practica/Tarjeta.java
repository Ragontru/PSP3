package practica;

import java.util.Random;

/**
 * Clase Tarjeta (Recurso compartido con los hilos Persona).
 * 
 * Cada tarjeta tiene su id, indicando su posici?n, y a cada persona le
 * corresponde 2 tarjetas concretras.
 * 
 * @author Raquel
 *
 */
public class Tarjeta {

	/**
	 * Variable para generar un tiempo aleatorio
	 */
	private Random tiempo = new Random();
	/**
	 * ID de la tarjeta
	 */
	private int id;
	/**
	 * Indica si la tarjeta est? libre o no. Si su valor es true, est? libre.
	 */
	private boolean libre = true;

	/**
	 * 
	 * Constructor de la clase Tarjeta
	 * 
	 * @param id ID de la tarjeta
	 */
	public Tarjeta(int id) {
		this.id = id;
	}

	/**
	 * Monitor para coger la tarjeta derecha. En caso de que no consiga cogerla en
	 * el tiempo dado, volver?a al estado de pensar
	 * 
	 * @param idPersona ID de la persona
	 * @return Si devuelve true, contin?a el proceso de uso porque tendr?a las dos
	 *         tarjetas; si devuelve false, volver?a al estado de pensar
	 * @throws InterruptedException
	 */
	public synchronized boolean cogerTarjetaDer(int idPersona) throws InterruptedException {
		while (!libre) {
			this.wait(tiempo.nextInt(5000) + 500);
			return false;
		}

		System.out.println("La persona " + idPersona + " coge la tarjeta " + id);
		libre = false;
		return true;
	}

	/**
	 * 
	 * Monitor para coger la tarjeta izquierda
	 * 
	 * @param idPersona ID de la persona
	 * @throws InterruptedException
	 */
	public synchronized void cogerTarjetaIzq(int idPersona) throws InterruptedException {
		while (!libre) {
			this.wait();
		}

		System.out.println("La persona " + idPersona + " coge la tarjeta " + id);

		libre = false;

	}

	/**
	 * Monitor para soltar las tarjetas y volver a pensar
	 * 
	 * @param idPersona ID de la persona
	 * @throws InterruptedException
	 */
	public synchronized void soltarTarjeta(int idPersona) {

		libre = true;
		System.out.println("La persona " + idPersona + " suelta la tarjeta " + id);
		this.notifyAll();
	}

}
