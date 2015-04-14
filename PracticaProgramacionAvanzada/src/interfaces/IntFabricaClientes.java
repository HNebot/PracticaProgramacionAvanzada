package interfaces;

import java.util.ArrayList;

import objetos.Cliente;
import enumeraciones.TipoCliente;

public interface IntFabricaClientes {
	public Cliente getCliente(TipoCliente Cliente, ArrayList<String> datos);

}
