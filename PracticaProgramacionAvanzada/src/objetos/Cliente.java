package objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Cliente implements Serializable
{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 3883647530742079062L;
	
	private String NIF;
	private String nombre;
	private int numeroTelefono;
	private String email;
	
	private Direccion direccion;
	
	private Calendar fechaAlta;
	
	private Tarifa tarifa;
	
	
	public Cliente(){
		
	}
	

	public Cliente(String nombre, String nIF, String email, int numeroTelefono,
			Direccion direccion, Calendar fechaAlta, Tarifa tarifa) {
		super();
		NIF = nIF;
		this.nombre = nombre;
		this.email = email;
		this.numeroTelefono = numeroTelefono;
		this.direccion = direccion;
		this.fechaAlta = fechaAlta;
		this.tarifa = tarifa;
	}



	public String getNIF() {
		return NIF;
	}



	public void setNIF(String nIF) {
		NIF = nIF;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	public int getNumeroTelefono() {
		return numeroTelefono;
	}


	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}


	public Direccion getDireccion() {
		return direccion;
	}



	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}



	public Calendar getFecha() {
		return fechaAlta;
	}



	public void setFecha(Calendar fechaAlta) {
		this.fechaAlta = fechaAlta;
	}



	public Tarifa getTarifa() {
		return tarifa;
	}



	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}



	@Override
	public String toString() {
		return "Cliente [NIF=" + NIF + ", nombre=" + nombre + ", email="
				+ email + ", direccion=" + direccion + ", fechaAlta="
				+ fechaAlta.toString() + ", tarifa=" + tarifa + "]";
	}
	
	public ArrayList<String> toArray()
	{
		ArrayList<String> datos = new ArrayList<String>();
		datos.add(getNombre());
		datos.add(getNIF());
		datos.add(getEmail());
		datos.add(getNumeroTelefono() +"");
		datos.add(getDireccion().newToString());
		datos.add(getTarifa().toString());
		return datos;
		
	}
	
	
	
	

}
