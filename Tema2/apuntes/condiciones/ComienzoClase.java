package condiciones;

public class ComienzoClase {

	public static void main(String[] args) {
		// Objeto compartido
		Bienvenida b = new Bienvenida();

		// Por argumento, el n�mero de hilos
		int nAlumnos = Integer.parseInt(args[0]);
		for (int i = 0; i < nAlumnos; i++) {
			new Alumno(b, i).start();
		}

		Profesor profesor = new Profesor("Jorge Rodr�guez", b);
		profesor.start();

	}

}
