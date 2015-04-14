package main;

import operaciones.OperacionesClientesConsola;
import operaciones.OperacionesFacturasConsola;
import operaciones.OperacionesLlamadasConsola;
import interfaces.IntIOInterface;
import interfaces.IntOperacionesClientes;
import interfaces.IntOperacionesFacturas;
import interfaces.IntOperacionesLlamadas;

/**
 * Clase para gestionar la salida de los datos por pantalla, en esta clase se gestiona la salida por consola.
 * Implemtena la interfaz IntIOInterface
 * @author Hector
 */
public class IOInterfazSalidaConsola implements IntIOInterface 
{
	private OperacionesClientesConsola opClintes;
	private OperacionesFacturasConsola opFacturas;
	private OperacionesLlamadasConsola opLlamadas;
	
	
	/**
	 * Contructor de la clase donde se intancian los menus de operaciones
	 */
	public IOInterfazSalidaConsola() {		
		this.opClintes = new OperacionesClientesConsola();
		this.opFacturas = new OperacionesFacturasConsola();
		this.opLlamadas = new OperacionesLlamadasConsola();
	}

	@Override
	public IntOperacionesClientes getOperacionesClientes() {
		// TODO Auto-generated method stub
		return this.opClintes;
	}

	@Override
	public IntOperacionesFacturas getOperacionesFacturas() {
		// TODO Auto-generated method stub
		return this.opFacturas;
	}

	@Override
	public IntOperacionesLlamadas getOperacionesLlamadas() {
		// TODO Auto-generated method stub
		return this.opLlamadas;
	}


}
