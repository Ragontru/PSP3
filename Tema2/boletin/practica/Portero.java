package practica;

public class Portero {

	/**
	 * Debe ser un asiento menos al n�mero de personas para asegurar que al menos
	 * una est� us�ndolo
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
	 * @param idPersona
	 * @throws InterruptedException
	 */
	public synchronized void dejarPersona(int idPersona) throws InterruptedException {
		asientosLibres++;
		System.out.println("La persona " + idPersona + " se levanta de la mesa.");
		this.notify();
	}

}
