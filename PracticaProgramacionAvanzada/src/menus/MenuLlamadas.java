package menus;

import java.util.Scanner;

public class MenuLlamadas 
{
	private Scanner scanner;
	
	public MenuLlamadas() {
		this.scanner = new Scanner(System.in);
	}
	
	public byte menuInicialLlamadas()
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
