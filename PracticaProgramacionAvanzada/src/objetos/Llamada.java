package objetos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Llamada extends Fecha implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2659701448875084153L;
	
	private int telefonoReceptor;
	private Calendar fecha;
	private int duracion;
	private float costeLlamada = -1;
	
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

		
	public float getCosteLlamada() {
		return costeLlamada;
	}

	public void setCosteLlamada(float costeLlamada) {
		this.costeLlamada = costeLlamada;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm");
		String info;
		info =  "telefonoReceptor: " + telefonoReceptor + ", fecha:"
				+ sdf.format(fecha.getTime()) + ", duracion: " + duracion + "min";
		
		if(costeLlamada != -1) info = info + " " + costeLlamada + "€";
		
		return info;
	}
	
	/**
	 * Devuelve un arrayList con los datos de la llamada.
	 * orden de los datos: pos0: telefono receptor, pos1: dia de la llamada, pos3: duracion.
	 * 
	 * @return arrayList de String con todos los datos de la llamada.
	 */
	public ArrayList<String> toArray()
	{
		ArrayList<String> datosLlamada = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm");
		datosLlamada.add(""+ this.getTelefonoReceptor());
		datosLlamada.add(sdf.format(this.getFecha().getTime()));
		datosLlamada.add(""+ this.getDuracion());
		return datosLlamada;
		
	}
	
	
	
	
}
