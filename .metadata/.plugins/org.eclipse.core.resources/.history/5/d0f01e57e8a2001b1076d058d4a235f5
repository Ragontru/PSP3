package practica;

public class Coworking {

	public static void main(String[] args) {

		Tarjeta[] tarjetas = new Tarjeta[5];
		Persona[] personas = new Persona[5];
		Portero portero = new Portero();

		for (int i = 0; i < tarjetas.length; i++) {
			tarjetas[i] = new Tarjeta(i);
		}

		for (int i = 0; i < personas.length - 1; i++) {
			personas[i] = new Persona(i, tarjetas[i], tarjetas[i + 1], portero);
			personas[i].start();
		}

		personas[4] = new Persona(4, tarjetas[4], tarjetas[0], portero);
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
