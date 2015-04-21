package interfaces;

import java.util.ArrayList;

import objetos.Cliente;
import tarifas.Tarifa;
import enumeraciones.TipoCliente;

public interface IntFabricaClientes {
	public Cliente getCliente(TipoCliente Cliente, ArrayList<String> datos, Tarifa tarifa);

}
