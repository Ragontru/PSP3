package ejercicio3;

/*
 * Los semáforos se pueden utilizar para controlar el acceso a un 
 * determinado recurso formado por un número finito de instancias. 
 * Un semáforo se representa como una variable entera donde su valor 
 * representa el número de instancias libres o disponibles en el 
 * recurso compartido y una cola donde se almacenan los procesos o 
 * hilos bloqueados esperando para usar el recurso En la fase de 
 * inicialización, se proporciona un valor inicial al semáforo 
 * igual al número de recursos inicialmente disponibles.
 */

import java.util.concurrent.Semaphore;

public class SeccionCriticaSemaforos {

	private static Sumador sumadores[];
	private static Semaphore semaphore = new Semaphore(1);

	public static void main(String[] args) {
		int nSum = Integer.parseInt(args[0]);
		sumadores = new Sumador[nSum];
		for (int i = 0; i < nSum; i++) {
			sumadores[i] = new Sumador(1000, i, semaphore);
			sumadores[i].start();
		}

		for (int i = 0; i < nSum; i++) {
			try {
				sumadores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Acumulador " + Acumula.acumulador);
	}

}
