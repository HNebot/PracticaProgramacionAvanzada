package main;

import interfaces.IntIOInterface;
import interfaces.IntMenuClientes;
import interfaces.IntMenuFacturas;
import interfaces.IntMenuLlamadas;

import java.util.Scanner;

import menus.*;

public class IOInterfazSalidaConsola implements IntIOInterface 
{
	private OperacionesClientesConsola opClintes;
	private OperacionesFacturasConsola opFacturas;
	private OperacionesLlamadasConsola opLlamadas;
	
	
	
	public IOInterfazSalidaConsola() {
		//this.scanner = new Scanner(System.in);
		
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
