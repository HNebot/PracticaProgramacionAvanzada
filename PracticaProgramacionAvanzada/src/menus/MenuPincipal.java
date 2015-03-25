package menus;

import java.util.Scanner;

public class MenuPincipal {
	
	private Scanner scanner;
	
	public MenuPincipal()
	{
		super();
		scanner = new Scanner(System.in);
	}
	
	public byte menuInicial()
	{
		System.out.println("Elija una opcion del menu:");
		System.out.println("1- Operaciones sobre clientes.");
		System.out.println("2- Operaciones sobre facturas.");
		System.out.println("3- Operaciones sobre llamadas.");
		System.out.println("0- Salir.");
		System.out.print("-->");
		
		return scanner.nextByte();
	}
	
	/*public void menuClientes()
	{
		System.out.println("Elija una opcion:");
		System.out.println("1- Nuevo cliente.");
		System.out.println("2- Ver cliente.");
		System.out.println("0- Salir.");
	}
	
	public boolean opcionesMenuInicial(String opt)
	{
		boolean salir = false;
		switch (opt){
			case "1":
				this.menuClientes();
				break;
			case "0":
				salir = true;
				break;				
		}
		return salir;
	}*/

}
