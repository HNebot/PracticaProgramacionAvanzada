package factorias;

import objetos.Cliente;
import objetos.Empresa;
import objetos.Particular;
import enumeraciones.TipoCliente;
import interfaces.IntFabricaClientes;

public class FabricaParametrizada implements IntFabricaClientes{

	@Override
	public Cliente getCliente(TipoCliente tipoCliente) {
		switch (tipoCliente) {
		case EMPRESA:
			return new Empresa();
		case PARTICULR:
			return new Particular();
		}
		return null;

	}

}
