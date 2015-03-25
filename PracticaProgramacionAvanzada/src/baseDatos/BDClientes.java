package baseDatos;

import java.util.HashMap;

import objetos.Cliente;

public class BDClientes 
{
	private HashMap<String, Cliente> clientes;
	
	public BDClientes() {
		this.clientes = new HashMap<String, Cliente>();
	}
	
	public boolean nuevoCliente (Cliente cliente)
	{
		if(clientes.containsKey(cliente.getNIF()))
		{
			return false;
		}
		else
		{
			clientes.put(cliente.getNIF(), cliente);
			return true;
		}
	}
	
	public Cliente buscarCliente(String nif)
	{
		if(clientes.containsKey(nif))
		{
			return this.clientes.get(nif);
		}
		else
		{
			return null;
		}
			
	}
	
	

}

