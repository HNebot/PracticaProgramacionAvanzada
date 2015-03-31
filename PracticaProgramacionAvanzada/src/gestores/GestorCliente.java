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
		try{
			String mensage = "Cliente registrado";
			
			Direccion direccion = new Direccion(datos.get(5), datos.get(6), datos.get(7), 
					datos.get(8), datos.get(9), Integer.parseInt(datos.get(10)));
			Calendar fechaAlta = Calendar.getInstance();
			Tarifa tarifa = new Tarifa(Float.parseFloat(datos.get(11)));
			
			if(datos.get(0) == "E")
			{
				this.cliente = new Empresa(datos.get(1), datos.get(2), datos.get(3), Integer.parseInt(datos.get(4)), direccion, fechaAlta, tarifa);
			}
			else
			{
				this.cliente = new Particular(datos.get(1), datos.get(2), datos.get(3), Integer.parseInt(datos.get(4)), direccion, fechaAlta, tarifa, datos.get(11));
			}
			
			if(!dbCliente.nuevoCliente(cliente))
			{
				mensage = "No se pudo dar de alta el cliente. \n Ya existe.";
				return mensage;
			}
			
			return mensage;
		}
		catch(NumberFormatException ex)
		{
			return "Error de formato.Introduzca los datos correctamente";
		}
	}
	
	public Cliente datosCliente(String nif)
	{
		return this.dbCliente.buscarCliente(nif);
	}
	
	public ArrayList<Cliente> getClientes()
	{
		try{
			return this.dbCliente.buscarClientes();
		}catch(Exception e)
		{
			return new ArrayList<Cliente>();
		}
	}
	
	@SuppressWarnings("finally")
	public String actualizarTarifa(String nif, String nuevaTarifa)
	{	
		String mensaje = "";
		try
		{
			Cliente cliente = this.datosCliente(nif);
			cliente.getTarifa().setTarifa(Float.parseFloat(nuevaTarifa));
			mensaje = "Tarifa actualizada";
		}
		catch(NumberFormatException e)
		{
			mensaje = "Error. La tarifa no es correcta";
		}
		catch(Exception e)
		{
			mensaje = e.getMessage();
		}
		finally
		{
			return mensaje;
		}
		
	}

}
