package main;

import interfaces.IntIOInterface;
import interfaces.IntMenuClientes;
import interfaces.IntMenuFacturas;
import interfaces.IntMenuLlamadas;

import java.util.Scanner;

import com.sun.org.glassfish.gmbal.Description;

import menus.*;

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
	public IntMenuClientes getOperacionesClientes() {
		// TODO Auto-generated method stub
		return this.opClintes;
	}

	@Override
	public IntMenuFacturas getOperacionesFacturas() {
		// TODO Auto-generated method stub
		return this.opFacturas;
	}

	@Override
	public IntMenuLlamadas getOperacionesLlamadas() {
		// TODO Auto-generated method stub
		return this.opLlamadas;
	}


}
