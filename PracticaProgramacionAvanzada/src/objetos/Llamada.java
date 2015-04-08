package objetos;

import java.io.Serializable;
import java.util.Date;


public class Llamada implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2659701448875084153L;
	
	private int telefonoReceptor;
	private Date fecha;
	private int duracion;
	
	public Llamada(int telefonoReceptor, Date fecha, int duracion) {
		super();
		this.telefonoReceptor = telefonoReceptor;
		this.fecha = fecha;
		this.duracion = duracion;
	}

	public int getTelefonoReceptor() {
		return telefonoReceptor;
	}

	public void setTelefonoReceptor(int telefonoReceptor) {
		this.telefonoReceptor = telefonoReceptor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	
	@Override
	public String toString() {
		return "Llamada [telefonoReceptor=" + telefonoReceptor + ", fecha="
				+ fecha + ", duracion=" + duracion + "]";
	}
	
	
	
	
}
