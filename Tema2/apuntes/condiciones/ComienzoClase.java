package condiciones;

public class ComienzoClase {

	public static void main(String[] args) {
		// Objeto compartido
		Bienvenida b = new Bienvenida();

		// Por argumento, el número de hilos
		int nAlumnos = Integer.parseInt(args[0]);
		for (int i = 0; i < nAlumnos; i++) {
			new Alumno(b, i).start();
		}

		Profesor profesor = new Profesor("Jorge Rodríguez", b);
		profesor.start();

	}

}
