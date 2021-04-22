package practica;

import java.util.Random;

/**
 * Clase Persona
 * 
 * 
 * 
 * @author Raquel
 *
 */
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
	/**
	 * Variable para el pc
	 */
	private PC pc;

	/**
	 * Constructor de la clase Persona
	 * 
	 * @param idPersona  ID de la persona
	 * @param tarjetaIzq Tarjeta izquierda
	 * @param tarjetaDer Tarjeta derecha
	 * @param asientos   Asientos libres
	 */
	public Persona(int idPersona, Tarjeta tarjetaIzq, Tarjeta tarjetaDer, Portero asientos, PC pc) {
		this.idPersona = idPersona;
		this.tarjetaIzq = tarjetaIzq;
		this.tarjetaDer = tarjetaDer;
		this.asientos = asientos;
		this.pc = pc;

	}

	/**
	 * Método run que se ejecuta indefinidamente, una por cada persona creada en la
	 * clase Coworking (principal)
	 */
	@Override
	public void run() {
		// Para que se repita indefinidamente
		while (true) {
			try {
				// Sentarse para hacer cola para trabajar
				asientos.aceptarPersona(idPersona);
				// Coger la tarjeta izquierda
				tarjetaIzq.cogerTarjetaIzq(idPersona);

				// Coger la tarjeta derecha
				if (!tarjetaDer.cogerTarjetaDer(idPersona)) {
					// Si no se consigue la tarjeta derecha, la persona se levantará y se volverá a
					// buscar otra persona
					System.out.println("La persona " + idPersona + " suelta la tarjeta " + idPersona
							+ " por exceso de tiempo en espera.");
					// Como no ha conseguido la tarjeta derecha, suelta la tarjeta izquierda y
					// libera el asiento
					tarjetaIzq.soltarTarjeta(idPersona);
					asientos.dejarPersona(idPersona);
					System.out.println("La persona " + idPersona + " está pensando.");

					try {
						// El tiempo que tarda la persona en pensar, entre 500 y 5000 milisegundos
						Persona.sleep((tiempo.nextInt(5000) + 500));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// Coger el pc
				if (!pc.cogerPC(idPersona) && tarjetaDer.cogerTarjetaDer(idPersona)) {
					// Si no consigue el pc, la persona se levantará y se volverá buscar a otra
					// persona
					System.out.println(
							"La persona " + idPersona + " suelta las tarjetas por exceso de tiempo en espera.");
					// Como no ha conseguido el pc, suelta ambas tarjetas y libera el asiento
					tarjetaDer.soltarTarjeta(idPersona);
					tarjetaIzq.soltarTarjeta(idPersona);
					asientos.dejarPersona(idPersona);
					System.out.println("La persona " + idPersona + " está pensando.");

					try {
						// El tiempo que tarda la persona en pensar, entre 500 y 5000 milisegundos
						Persona.sleep((tiempo.nextInt(5000) + 500));
					} catch (InterruptedException e) {
						System.err.println("Error en el tiempo de pensar.");
					}

				}

				// Si consigue ambas tarjetas y el pc
				System.out.println("La persona " + idPersona + " está trabajando.");
				// Tiempo aleatorio que pasa la persona trabajando
				try {
					sleep(tiempo.nextInt(5000) + 500);
				} catch (InterruptedException e) {
					System.err.println("Error en el tiempo de trabajo.");
				}
				// Suelta las tarjetas y libera el asiento
				pc.soltarPC(idPersona);
				tarjetaIzq.soltarTarjeta(idPersona);
				tarjetaDer.soltarTarjeta(idPersona);
				asientos.dejarPersona(idPersona);

				System.out.println("La persona " + idPersona + " está pensando.");
				try {
					Persona.sleep(tiempo.nextInt(5000) + 500);
				} catch (InterruptedException e) {
					System.err.println("Error en el tiempo de pensar.");
				}

			} catch (InterruptedException e) {
				System.err.println("Ha ocurrido un error");
				// e.printStackTrace();
			}

		}
	}

}
