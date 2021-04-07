package ejercicio1;

public class Padre {

	public static void main(String[] args) {

		int n = 10;

		System.out.println(
				"Ejercicio 1: Crea un hilo que realice el cálculo de los primeros N número de la sucesión de\r\n"
						+ "Fibonacci. La sucesión de Fibonacci comienza con los números 1 y 1, y el siguiente elemento es\r\n"
						+ "la suma de los dos elementos anteriores. Así la sucesión de Fibonacci sería 1, 1, 2, 3, 5, 8, 13, 21,\r\n"
						+ "34, 55… El parámetro N será indicado cuando se llame al constructor de la clase Thread\r\n"
						+ "correspondiente.");

		new Hijo(n);
	}

}
