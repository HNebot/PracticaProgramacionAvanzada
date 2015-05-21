package interfaces;

import gestores.GestorClientes;
import gestores.GestorFacturas;
import gestores.GestorLlamadas;

public interface IntModeloGestor 
{
	GestorClientes getGestorCliente();
	GestorFacturas getGestorFacturas();
	GestorLlamadas getGestorLlamadas();

	
}
