package objetos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Llamada implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2659701448875084153L;
	
	private int telefonoReceptor;
	private Calendar fecha;
	private int duracion;
	
	public Llamada(int telefonoReceptor, Calendar fecha, int duracion) {
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

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
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
	
	public ArrayList<String> toArray()
	{
		ArrayList<String> datosLlamada = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		datosLlamada.add(""+ this.getTelefonoReceptor());
		datosLlamada.add(sdf.format(this.getFecha().getTime()));
		datosLlamada.add(""+ this.getDuracion());
		return datosLlamada;
		
	}
	
	
	
	
}
