package objetos;

import java.util.Calendar;
import java.util.Date;

public class Empresa extends Cliente
{
	
	public Empresa(){
		super();
	}

	public Empresa(String nIF, String nombre, String email,
			Direccion direccion, Calendar fechaAlta, Tarifa tarifa) {
		super(nIF, nombre, email, direccion, fechaAlta, tarifa);
	}
	

	@Override
	public String toString() {
		return "Empresa []";
	}
	
}
