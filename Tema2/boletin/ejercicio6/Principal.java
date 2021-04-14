package ejercicio6;

/* Ejercicio 6: Crea una clase Java que utilice 5 hilos para 
 * contar el n�mero de vocales que hay un determinado texto 
 * que se debe leer de un fichero. Cada hilo se encargar� de 
 * contar una vocal diferente, actualizando todos los hilos 
 * la misma variable com�n que representa el n�mero de vocales 
 * totales. Para evitar condiciones de carrera se deben 
 * utilizar m�todos sincronizados.
*/

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		CuentaVocal hilos[];
		char vocales[] = { 'a', 'e', 'i', 'o', 'u' };
		hilos = new CuentaVocal[vocales.length];

		for (int i = 0; i < vocales.length; i++) {
			hilos[i] = new CuentaVocal(vocales[i]);
			hilos[i].run();
		}

		for (int i = 0; i < hilos.length; i++) {
			hilos[i].join();
		}

		System.out.println(ContadorGlobal.totalVocales);

	}

}
