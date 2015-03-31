package objetos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Particular extends Cliente
{
	
	private String apellido;
	
	public Particular(){
		super();
	}
	
	public Particular(String nIF, String nombre, String email, int numeroTelefono,
			Direccion direccion, Calendar fechaAlta, Tarifa tarifa, String apellido) {
		super(nIF, nombre, email, numeroTelefono, direccion, fechaAlta, tarifa);
		
		this.apellido = apellido;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	

	@Override
	public String toString() {
		return super.toString() + "Particular [apellido=" + apellido + "]";
	}
	
	@Override
	public ArrayList<String> toArray() {
		ArrayList<String> datos = super.toArray();
		datos.add(getApellido());
		return datos;
	}

	

}
