package objetos;

import java.util.Calendar;
import java.util.Date;

public class Particular extends Cliente
{
	
	private String apellido;
	
	public Particular(){
		super();
	}
	
	public Particular(String nIF, String nombre, String email,
			Direccion direccion, Calendar fechaAlta, Tarifa tarifa, String apellido) {
		super(nIF, nombre, email, direccion, fechaAlta, tarifa);
		
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

	

}
