package practica;

public class Correo {

	private String receptor;
	private String emisor;
	private String mensaje;

	public Correo() {

	}

	public Correo(String receptor, String emisor, String mensaje) {
		this.receptor = receptor;
		this.emisor = emisor;
		this.mensaje = mensaje;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String toString() {
		return "Usuario: " + receptor + " -- Enviado por: " + emisor + " --- Mensaje: " + mensaje;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else {
			return this.emisor.equals(((Correo) o).emisor) && this.receptor.equals(((Correo) o).receptor)
					&& this.mensaje.equals(((Correo) o).mensaje);
		}
	}

}
