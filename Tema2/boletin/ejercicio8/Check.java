package ejercicio8;

/*
 * Ejercicio 8: Escribe una clase llamada Check que cree dos 
 * threads que accedan simult�neamente a un buffer de 10000 
 * enteros. Uno de ellos lee en el buffer y el otro escribe 
 * en el mismo. El thread escritor debe escribir el mismo 
 * valor en todos los elementos del buffer incrementando
 * en uno el valor en cada pasada. El thread lector debe ir 
 * comprobando que todos los n�meros del buffer son iguales, 
 * mostrando un mensaje de error en caso contrario o un 
 * mensaje de correcto si la condici�n se cumple. El c�digo 
 * a realizar utilizar� un monitor para acceder al buffer 
 * si se indica un par�metro al ejecutar el programa. En caso 
 * contrario, los threads acceder�n al buffer sin hacer uso 
 * del monitor.
 */

public class Check {

	public static void main(String[] args) {
		ClaseBuffer buffer = new ClaseBuffer();
		HiloIncrementa h1 = new HiloIncrementa(buffer);
		HiloLector h2 = new HiloLector(buffer);

		buffer.muestra();
		System.out.println("--------------------------------------");
		h1.start();
		h2.start();
		try {
			h1.join();
			h2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		buffer.muestra();

	}

}
