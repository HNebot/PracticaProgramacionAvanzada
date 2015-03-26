package menus;

import interfaces.IntMenuClientes;

import java.util.ArrayList;
import java.util.Scanner;

import objetos.Cliente;
import objetos.Particular;

public class MenuClientesConsola implements IntMenuClientes
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
		ArrayList<String> datosEntrada = new ArrayList<String>(13);
		String tipo;
		this.scanner.nextLine();
		do{
			System.out.println("Cliente particulas(P) o empresa(E)?");
			tipo = this.scanner.nextLine();
			tipo = tipo.toUpperCase();
		}
		while(tipo.equals("E") == false && tipo.equals("P") == false);
		datosEntrada.add(0, tipo);
		
		System.out.print("Nombre: ");
		datosEntrada.add(1,this.scanner.nextLine());
		String apellido ="";
		
		if(tipo.equals("P"))
		{
			System.out.print("Apellido: ");
			apellido = this.scanner.nextLine();
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
		if(tipo.equals("P"))
		{
			datosEntrada.add(11,apellido);			
		}
		System.out.println("");
		
		
		return datosEntrada;
	}
	
	public String menuVerCliente()
	{
			this.scanner.nextLine();
			System.out.println("Introduzca el NIF del cliente que desea buscar: ");
			System.out.print("--> ");
			return this.scanner.nextLine();
	}

	@Override
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
		
	}

	@Override
	public void formatoInfoCliente(Cliente cliente) {
		ArrayList<String> informacion = cliente.toArray();
		String info = "";
		info = info + "Nombre: " + informacion.get(0);
		if(cliente.getClass().getSimpleName().toString().equals("Particular"))
		{
			info = info + " " + informacion.get(5);
		}
		info = info + "\n" + "NIF: " + informacion.get(1) + "\n";
		info = info + "Email: " + informacion.get(2) + "\n";
		info = info + "Dirección: " + informacion.get(3) + "\n";
		info = info + "Tarifa: " + informacion.get(4) +  "\n";
		
		System.out.println("=====================");
		System.out.print(info);
		System.out.println("=====================");
		
		
	}

}
