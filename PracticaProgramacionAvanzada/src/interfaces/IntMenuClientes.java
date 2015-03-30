package interfaces;

import java.util.ArrayList;

import objetos.Cliente;

public interface IntMenuClientes extends IntMenu
{
	public ArrayList<String> menuNuevoCliente();
	public String menuVerCliente();
	public void mostrarMensaje(String mensaje);
	public void formatoInfoCliente(Cliente cliente);
	public void mostrarClientes(ArrayList<Cliente> clientes);
}
