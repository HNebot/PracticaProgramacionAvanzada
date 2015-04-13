package interfaces;

import java.util.ArrayList;
import java.util.Calendar;

import objetos.Cliente;

public interface IntMenuClientes
{
	
	public ArrayList<String> menuNuevoCliente();
	public String menuVerCliente();
	public void mostrarMensaje(String mensaje);
	public void formatoInfoCliente(Cliente cliente);
	public void mostrarClientes(ArrayList<Cliente> clientes);
	public String actualizarTarifa();
	public ArrayList<Calendar> buscarClientesPorFechaAlta();
}
