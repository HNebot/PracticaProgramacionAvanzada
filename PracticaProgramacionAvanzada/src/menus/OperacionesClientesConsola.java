package menus;

import interfaces.IntMenuClientes;

import java.util.ArrayList;
import java.util.Scanner;

import lectura.LecturaDatosConsola;
import objetos.Cliente;
import salida.SalidaInfoConsola;

/**
 * @author Hector
 * Esta clase es la que gestiona las salidas por pantalla, en este por consola de la informacion de los clientes
 * 
 * Implementa una interfaz IntMenuClientes que a su vez extiende una de tipo Menu
 */
public class OperacionesClientesConsola implements IntMenuClientes
{
	private Scanner scanner;
	private LecturaDatosConsola lectura;
	
	/**
	 * Contructor principal de la clase
	 * Le pasamos un Scanner con el que recojeremos la informacion introducida
	 * @param scanner
	 */
	public OperacionesClientesConsola(Scanner scanner) {
		this.scanner = scanner;
	}
	public OperacionesClientesConsola() {
		this.lectura = new LecturaDatosConsola();
	}
	
	
	/**
	 * Muestra y recoje los datos necesarios para introducir un nuevo cliente
	 * 
	 * Retorna un ArrayList de String
	 */
	@Override
	public ArrayList<String> menuNuevoCliente()
	{
		ArrayList<String> datosEntrada = new ArrayList<String>(14);
		String tipo;
		do{
			System.out.println("Cliente particulas(P) o empresa(E)?");
			tipo = this.scanner.nextLine();
			tipo = this.lectura.lecturaDatos();
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
		System.out.print("telefono: ");
		datosEntrada.add(4,this.scanner.nextLine());
		System.out.print("Calle: ");
		datosEntrada.add(5,this.scanner.nextLine());
		System.out.print("Portal: ");
		datosEntrada.add(6,this.scanner.nextLine());
		System.out.print("Piso y portal: ");
		datosEntrada.add(7,this.scanner.nextLine());
		System.out.print("Poblacion: ");
		datosEntrada.add(8,this.scanner.nextLine());
		System.out.print("Porvincia: ");
		datosEntrada.add(9,this.scanner.nextLine());
		System.out.print("C�digo postal: ");
		datosEntrada.add(10,this.scanner.nextLine());
		System.out.print("Tarifa: ");
		datosEntrada.add(11,this.scanner.nextLine());
		if(tipo.equals("P"))
		{
			datosEntrada.add(12,apellido);			
		}
		System.out.println("");
		
		scanner.close();
		return datosEntrada;
	}
	
	/**
	 * Pide la informacion para buscar un cliente
	 * retorna un String
	 */
	@Override
	public String menuVerCliente()
	{
			System.out.println("Introduzca el NIF del cliente: ");
			System.out.print("--> ");
			return this.lectura.lecturaDatos();
	}

	/**
	 * Muestra los mensajes de confirmaci�n o errores
	 */
	@Override
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
		
	}

	/**
	 * Muestra por patalla los datos del cliente que se le pasa comprovando si es un Particular o una Empresa
	 * @param cliente
	 */
	@Override
	public void formatoInfoCliente(Cliente cliente) {
		ArrayList<String> informacion = cliente.toArray();
		String info = "";
		info = info + "Nombre: " + informacion.get(0);
		if(cliente.getClass().getSimpleName().toString().equals("Particular"))
		{
			info = info + " " + informacion.get(6);
		}
		info = info + "\n" + "NIF: " + informacion.get(1) + "\n";
		info = info + "Email: " + informacion.get(2) + "\n";
		info = info + "Telefono: " + informacion.get(3) + "\n";
		info = info + "Direcci�n: " + informacion.get(4) + "\n";
		info = info + "Tarifa: " + informacion.get(5) +  "\n";
		
		System.out.println("=====================");
		System.out.print(info);
		System.out.println("=====================");
	}
	
	/**
	 * Recorre la lista con todos los clientes para mostrarlos por pantalla
	 * Llama a   para mostrar la informacion
	 * @param clientes
	 */
	@Override
	public void mostrarClientes(ArrayList<Cliente> clientes)
	{
		String info = "No hay clientes";
		
		if(clientes == null || clientes.isEmpty())
		{
			System.out.println(info);
		}
		else
		{
			for(int i = 0; i<clientes.size(); i++)
			{
				this.formatoInfoCliente(clientes.get(i));
			}
		}
	}

	@Override
	public String actualizarTarifa()
	{
		System.out.println("Introduzca la nuva tarifa del cliente: ");
		System.out.print("--> ");
		return this.lectura.lecturaDatos();
		
	}

}
