package ejercicio2;

public class Orden {

	public static void main(String[] args) {

		System.out.println(
				"Ejercicio 2: Escribe una clase llamada Orden que cree dos hilos y fuerce que la escritura del\r\n"
						+ "segundo sea siempre anterior a la escritura por pantalla del primero.\r\n"
						+ "Ejemplo de ejecuci�n:\r\n" + "Hola, soy el thread n�mero 2\r\n"
						+ "Hola, soy el thread n�mero 1");

		Hijo hijo1 = new Hijo("Hilo 1");
		hijo1.setPriority(1);

		Hijo hijo2 = new Hijo("Hilo 2");
		hijo2.setPriority(10);

		hijo1.start();
		hijo2.start();

	}

}
