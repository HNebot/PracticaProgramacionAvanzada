package interfaces;

import java.util.ArrayList;

import objetos.Cliente;
import enumeraciones.TipoCliente;
import enumeraciones.TipoTarifaFinDeSemana;
import enumeraciones.TipoTarifaHoraria;

public interface IntFabricaClientes {
	public Cliente getCliente(TipoCliente Cliente, ArrayList<String> datos, 
			TipoTarifaHoraria tarifaHoraria, TipoTarifaFinDeSemana tarifaFinSemana);

}
