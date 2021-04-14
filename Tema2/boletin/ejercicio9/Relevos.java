package ejercicio9;

/*
 * Ejercicio 9: Escribe una clase llamada Relevos que simule una 
 * carrera de relevos de la siguiente forma:
 * 
 * 	� Crea 4 threads, que se quedar�n a la espera de recibir 
 * 		alguna se�al para comenzar a correr. Una vez creados los 
 * 		threads, se indicar� que comience la carrera, con lo que 
 * 		uno de los threads deber� empezar a correr.
 * 	� Cuando un thread termina de correr pone alg�n mensaje en 
 * 		pantalla y espera un par de segundos, pasando el testigo 
 * 		a otro de los hilos para que comience a correr, y 
 * 		terminando su ejecuci�n.
 * 	� Cuando el �ltimo thread termine de correr, el padre mostrar� 
 * 		un mensaje indicando que todos los hijos han terminado.
 */

public class Relevos {
	
	public static void main(String[] args) {
		// Objeto compartido
		Carrera c = new Carrera();
		
		int nCorredores = Integer.parseInt(args[0]);
		for (int i = 0; i < nCorredores; i++) {
			new Corredor(c, i).start();
		}
		
		System.out.println("Todos los corredores creados.");
	}

}
