package gestores;

import java.util.ArrayList;
import java.util.Calendar;

import baseDatos.BDClientes;
import objetos.Cliente;
import objetos.Direccion;
import objetos.Empresa;
import objetos.Particular;
import objetos.Tarifa;

public class GestorCliente 
{
	private Cliente cliente;
	private BDClientes dbCliente = new BDClientes();
	
	public GestorCliente(){
		super();
	}
	
	public String altaCliente (ArrayList<String> datos)
	{
		String mensage = "Cliente registrado";
		
		Direccion direccion = new Direccion(datos.get(4), datos.get(5), datos.get(6), 
				datos.get(7), datos.get(8), Integer.parseInt(datos.get(9)));
		Calendar fechaAlta = Calendar.getInstance();
		Tarifa tarifa = new Tarifa(Float.parseFloat(datos.get(10)));
		
		if(datos.get(0) == "E")
		{
			this.cliente = new Empresa(datos.get(1), datos.get(2), datos.get(3), direccion, fechaAlta, tarifa);
		}
		else
		{
			this.cliente = new Particular(datos.get(1), datos.get(2), datos.get(3), direccion, fechaAlta, tarifa, datos.get(11));
		}
		
		if(!dbCliente.nuevoCliente(cliente))
		{
			mensage = "No se pudo dar de alta el cliente. \n Ya existe.";
			return mensage;
		}
		
		return mensage;
	}
	
	public Cliente datosCliente(String nif)
	{
		return this.dbCliente.buscarCliente(nif);
	}

}
