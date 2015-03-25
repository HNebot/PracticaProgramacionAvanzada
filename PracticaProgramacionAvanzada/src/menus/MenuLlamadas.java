package menus;

import interfaces.Menu;

import java.util.Scanner;

public class MenuLlamadas implements Menu
{
	private Scanner scanner;
	
	public MenuLlamadas(Scanner scanner) {
		this.scanner = scanner;
	}
	
	@Override
	public byte menuInicial()
	{
		System.out.println("Elija una opcion:");
		System.out.println("1- Nueva llamada.");
		System.out.println("2- Ver llamadas de un cliente.");
		System.out.println("3- Ver llamadas de una factura.");
		System.out.println("0- Salir.");
		System.out.print("->");
		
		return this.scanner.nextByte();
	}

}
