package practica;

/**
 * Clase Portero (Recurso compartido con los hilos Persona).
 * 
 * Permite el control de acceso al resto de recursos impidiendo que se produzcan
 * posibles interbloqueos
 * 
 * @author Raquel
 *
 */
public class Portero {

	/**
	 * Debe ser un asiento menos al número de personas para asegurar que al menos
	 * una esté usándolo
	 */
	private int asientosLibres = 4;

	/**
	 * Monitor para aceptar que se siente una persona
	 * 
	 * @param idPersona ID de la persona
	 * @throws InterruptedException
	 */
	public synchronized void aceptarPersona(int idPersona) throws InterruptedException {
		while (asientosLibres == 0) {
			this.wait();
		}

		System.out.println("La persona " + idPersona + " se ha sentado en la mesa.");
		asientosLibres--;
	}

	/**
	 * Monitor para liberar un asiento y notificar que existe una persona libre
	 * 
	 * @param idPersona ID de la persona
	 * @throws InterruptedException
	 */
	public synchronized void dejarPersona(int idPersona){
		asientosLibres++;
		System.out.println("La persona " + idPersona + " se levanta de la mesa.");
		this.notifyAll();
	}

}
