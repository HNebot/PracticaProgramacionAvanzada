package menus;

import interfaces.IntMenuFacturas;

import java.util.Scanner;

public class MenuFacturasConsola implements IntMenuFacturas 
{
	private Scanner scanner;
	
	public MenuFacturasConsola(Scanner scanner) {
		this.scanner = scanner;
	}
	
	@Override
	public String getMenu()
	{
		System.out.println("Elija una opcion:");
		System.out.println("1- Nueva factura.");
		System.out.println("2- Ver factura de un cliente.");
		System.out.println("3- Listar facturas de un cliente.");
		System.out.println("0- Salir.");
		System.out.print("->");
		
		return "";
		//return this.scanner.nextByte();
	}

}
