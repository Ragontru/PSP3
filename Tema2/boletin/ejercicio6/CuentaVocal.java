package ejercicio6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CuentaVocal extends Thread {
	private char vocal;
	private ContadorGlobal var;
	private BufferedReader br;
	private FileReader fr;

	public CuentaVocal(char vocal) {
		this.vocal = vocal;
		try {
			File f = new File("./src/Ej6/archivo.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		leeArchivo();
	}

	private void leeArchivo() {
		String linea;
		try {
			while ((linea = br.readLine()) != null) {
				for (int i = 0; i < linea.length(); i++) {
					linea = linea.toLowerCase();
					if (linea.charAt(i) == this.vocal) {
						sumaVocal();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private synchronized void sumaVocal() {
		var.totalVocales++;
	}

}
