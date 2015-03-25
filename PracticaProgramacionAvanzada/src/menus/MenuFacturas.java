package menus;

import interfaces.Menu;

import java.util.Scanner;

public class MenuFacturas implements Menu 
{
	private Scanner scanner;
	
	public MenuFacturas(Scanner scanner) {
		this.scanner = scanner;
	}
	
	@Override
	public byte menuInicial()
	{
		System.out.println("Elija una opcion:");
		System.out.println("1- Nueva factura.");
		System.out.println("2- Ver factura de un cliente.");
		System.out.println("3- Listar facturas de un cliente.");
		System.out.println("0- Salir.");
		System.out.print("->");
		
		return this.scanner.nextByte();
	}

}
