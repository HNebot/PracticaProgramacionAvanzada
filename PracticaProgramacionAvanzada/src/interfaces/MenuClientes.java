package interfaces;

import java.util.ArrayList;

import objetos.Cliente;

public interface MenuClientes extends Menu
{
	public ArrayList<String> menuNuevoCliente();
	public String menuVerCliente();
	public void mostrarMensaje(String mensaje);
	public void formatoInfoCliente(Cliente cliente);
}
