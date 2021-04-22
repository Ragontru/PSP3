package practica;

/**
 * COWORKING
 * Práctica entregable del tema 2 de PSP: Programación Multihilos
 * 
 * @author Raquel
 *
 */
public class Coworking {

	public static void main(String[] args) {

		Tarjeta[] tarjetas = new Tarjeta[5];
		Persona[] personas = new Persona[5];
		PC pc = new PC();
		Portero portero = new Portero();

		for (int i = 0; i < tarjetas.length; i++) {
			tarjetas[i] = new Tarjeta(i);
		}

		for (int i = 0; i < personas.length - 1; i++) {
			personas[i] = new Persona(i, tarjetas[i], tarjetas[i + 1], portero, pc);
			personas[i].start();
		}

		personas[4] = new Persona(4, tarjetas[4], tarjetas[0], portero, pc);
		personas[4].start();

		for (int i = 0; i < personas.length; i++) {
			try {
				personas[i].join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
