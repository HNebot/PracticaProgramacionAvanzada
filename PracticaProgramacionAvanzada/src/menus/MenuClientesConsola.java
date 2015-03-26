package menus;

import interfaces.MenuClientes;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuClientesConsola implements MenuClientes
{
	private Scanner scanner;
	
	public MenuClientesConsola(Scanner scanner) {
		this.scanner = scanner;
	}
	
	@Override
	public byte menuInicial()
	{
		System.out.println("Elija una opcion:");
		System.out.println("1- Nuevo cliente.");
		System.out.println("2- Ver cliente.");
		System.out.println("3- Listar clientes.");
		System.out.println("0- Salir.");
		System.out.print("->");
		
		return this.scanner.nextByte();
	}
	
	public ArrayList<String> menuNuevoCliente()
	{
		ArrayList<String> datosEntrada = new ArrayList<String>();
		String tipo;
		do{
			System.out.println("Cliente particulas(P) o empresa(M)?");
			tipo = this.scanner.nextLine();
			tipo.toUpperCase();
		}
		while(!tipo.equals("M") || !tipo.equals("P"));
		datosEntrada.add(0, tipo);
		
		System.out.print("Nombre: ");
		datosEntrada.add(1,this.scanner.nextLine());
		
		if(tipo.equals("P"))
		{
			System.out.print("Apellido: ");
			datosEntrada.add(11,this.scanner.nextLine());			
		}
		
		System.out.print("NIF: ");
		datosEntrada.add(2,this.scanner.nextLine());
		System.out.print("email: ");
		datosEntrada.add(3,this.scanner.nextLine());
		System.out.print("Calle: ");
		datosEntrada.add(4,this.scanner.nextLine());
		System.out.print("Portal: ");
		datosEntrada.add(5,this.scanner.nextLine());
		System.out.print("Piso y portal: ");
		datosEntrada.add(6,this.scanner.nextLine());
		System.out.print("Poblacion: ");
		datosEntrada.add(7,this.scanner.nextLine());
		System.out.print("Porvincia: ");
		datosEntrada.add(8,this.scanner.nextLine());
		System.out.print("Código postal: ");
		datosEntrada.add(9,this.scanner.nextLine());
		System.out.print("Tarifa: ");
		datosEntrada.add(10,this.scanner.nextLine());
		System.out.println("");
		
		
		return datosEntrada;
	}
	
	public String menuVerCliente()
	{
			System.out.println("Introduzca el NIF del cliente que desea buscar: ");
			System.out.print("--> ");
			return this.scanner.nextLine();
	}

}
