package ejercicio3;

import java.util.concurrent.Semaphore;

public class SeccionCriticaSemaforos {

	private static Sumador sumadores[];
	private static Semaphore semaphore = new Semaphore(1);

	public static void main(String[] args) {
		int nSum = Integer.parseInt(args[0]);
	}

}