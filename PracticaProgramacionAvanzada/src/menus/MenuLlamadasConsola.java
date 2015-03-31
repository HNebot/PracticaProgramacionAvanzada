package menus;

import interfaces.IntMenuLlamadas;

import java.util.Scanner;

public class MenuLlamadasConsola implements IntMenuLlamadas
{
	private Scanner scanner;
	
	public MenuLlamadasConsola(Scanner scanner) {
		this.scanner = scanner;
	}
	
	@Override
	public String getMenu()
	{
		System.out.println("Elija una opcion:");
		System.out.println("1- Nueva llamada.");
		System.out.println("2- Ver llamadas de un cliente.");
		System.out.println("3- Ver llamadas de una factura.");
		System.out.println("0- Salir.");
		System.out.print("->");
		
		return "";
		//return this.scanner.nextByte();
	}

}
