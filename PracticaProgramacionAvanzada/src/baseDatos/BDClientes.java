package baseDatos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	public ArrayList<Cliente> buscarClientes()
	{
		ArrayList<Cliente> clientesList = new ArrayList<Cliente>();
		
		for (Map.Entry<String, Cliente> entry : clientes.entrySet()) { 
			clientesList.add(entry.getValue());
		}
		
		return clientesList;
	}
	
	
	
	

}

