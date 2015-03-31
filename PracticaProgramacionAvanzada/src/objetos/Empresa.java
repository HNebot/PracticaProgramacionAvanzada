package objetos;

import java.util.Calendar;
import java.util.Date;

public class Empresa extends Cliente
{
	
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
