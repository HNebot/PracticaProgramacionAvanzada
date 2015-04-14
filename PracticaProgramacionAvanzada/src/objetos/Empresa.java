package objetos;

import java.io.Serializable;
import java.util.Calendar;

import tarifas.Tarifa;

public class Empresa extends Cliente implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5059267608213331264L;


	public Empresa(){
		super();
	}

	public Empresa(String nIF, String nombre, String email, int numeroTelefono,
			Direccion direccion, Calendar fechaAlta, Tarifa tarifa) {
		super(nIF, nombre, email, numeroTelefono, direccion, fechaAlta, tarifa);
	}
	

	@Override
	public String toString() {
		return "Empresa []";
	}
	
}
