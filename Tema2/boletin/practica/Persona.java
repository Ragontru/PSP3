package practica;

import java.util.Random;

public class Persona extends Thread {

	/**
	 * Variable para generar un tiempo aleatorio
	 */
	private Random tiempo = new Random();
	/**
	 * ID de la persona
	 */
	private int idPersona;
	/**
	 * Variables para las tarjetas
	 */
	private Tarjeta tarjetaIzq, tarjetaDer;
	/**
	 * Variables para los asientos libres
	 */
	private Portero asientos;

	public Persona(int idPersona, Tarjeta tarjetaIzq, Tarjeta tarjetaDer, Portero asientos) {
		this.idPersona = idPersona;
		this.tarjetaIzq = tarjetaIzq;
		this.tarjetaDer = tarjetaDer;
		this.asientos = asientos;

	}

	/**
	 * 
	 */
	@Override
	public void run() {

		try {
			// Sentarse para hacer cola para trabajar
			asientos.aceptarPersona(idPersona);
			// Coger la tarjeta izquierda
			tarjetaIzq.cogerTarjetaIzq(idPersona);

			// Coger la tarjeta derecha
			if (!tarjetaDer.cogerTarjetaDer(idPersona)) {
				// Si no se consigue la tarjeta derecha, la persona se levantar� y se volver� a
				// buscar otra persona
				System.out.println("La persona " + idPersona + " suelta la tarjeta izquierda " + idPersona
						+ " por exceso de tiempo.");
				// Como no ha conseguido la tarjeta derecha, suelta la tarjeta izquierda y
				// libera el asiento
				tarjetaDer.soltarTarjeta(idPersona);
				asientos.dejarPersona(idPersona);
				System.out.println("La persona " + idPersona + " est� pensando.");

				try {
					// El tiempo que tarda la persona en pensar, entre 2000 y 5000 milisegundos
					Persona.sleep((tiempo.nextInt(5000) + 2000));
				} catch (InterruptedException ex) {
					System.out.println("Error. Descripci�n: " + ex.toString());
				}
			}

			// Si consigue la tarjeta derecha
			System.out.println("La persona " + idPersona + " est� trabajando.");
			// Tiempo aleatorio que pasa la persona trabajando
			try {
				sleep(tiempo.nextInt(5000) + 2000);
			} catch (InterruptedException e) {
				System.err.println("Error en el tiempo de trabajo.");
			}
			// Suelta las tarjetas y libera el asiento
			tarjetaIzq.soltarTarjeta(idPersona);
			tarjetaDer.soltarTarjeta(idPersona);
			asientos.dejarPersona(idPersona);

			System.out.println("La persona " + idPersona + " est� pensando.");
			try {
				Persona.sleep(tiempo.nextInt(5000) + 2000);
			} catch (InterruptedException e) {
				System.err.println("Error en el tiempo de pensar.");
			}

		} catch (InterruptedException e) {
			System.err.println("Ha ocurrido un error");
			// e.printStackTrace();
		}

	}

}