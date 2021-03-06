package factorias;

import java.util.ArrayList;
import java.util.Calendar;

import objetos.Cliente;
import objetos.Direccion;
import objetos.Empresa;
import objetos.Particular;
import tarifas.Tarifa;
import enumeraciones.TipoCliente;

import interfaces.IntFabricaClientes;

public class FabricaParametrizadaClientes implements IntFabricaClientes{
	
	@Override
	public Cliente getCliente(TipoCliente tipoCliente, ArrayList<String> datos, Tarifa tarifa) {
		Direccion direccion = new Direccion(datos.get(4), datos.get(5), datos.get(6), 
				datos.get(7), datos.get(8), Integer.parseInt(datos.get(9)));
		Calendar fechaAlta = Calendar.getInstance();
		
		switch (tipoCliente) {
		case EMPRESA:
			return new Empresa(datos.get(0), datos.get(1), datos.get(2), 
					Integer.parseInt(datos.get(3)), direccion, fechaAlta, tarifa);
		case PARTICULR:
			return new Particular(datos.get(0), datos.get(1), datos.get(2), 
					Integer.parseInt(datos.get(3)), direccion, fechaAlta, tarifa, datos.get(10));
		}
		return null;

	}

}
