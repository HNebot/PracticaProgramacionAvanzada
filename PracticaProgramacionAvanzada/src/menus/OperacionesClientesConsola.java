package menus;

import interfaces.IntMenuClientes;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	private LecturaDatosConsola lectura;
	
	/**
	 * Contructor principal de la clase
	 * Instanciamos un objeto de tipo lectura para leer datos por consola
	 */	public OperacionesClientesConsola() {
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
			tipo = this.lectura.lecturaDatos();
			tipo = tipo.toUpperCase();
		}
		while(tipo.equals("E") == false && tipo.equals("P") == false);
		datosEntrada.add(0, tipo);
		
		System.out.print("Nombre: ");
		datosEntrada.add(1,this.lectura.lecturaDatos());
		String apellido ="";
		
		if(tipo.equals("P"))
		{
			System.out.print("Apellido: ");
			apellido = this.lectura.lecturaDatos();
		}
		
		System.out.print("NIF: ");
		datosEntrada.add(2,this.lectura.lecturaDatos());
		System.out.print("email: ");
		datosEntrada.add(3,this.lectura.lecturaDatos());
		System.out.print("telefono: ");
		datosEntrada.add(4,this.lectura.lecturaDatos());
		System.out.print("Calle: ");
		datosEntrada.add(5,this.lectura.lecturaDatos());
		System.out.print("Portal: ");
		datosEntrada.add(6,this.lectura.lecturaDatos());
		System.out.print("Piso y portal: ");
		datosEntrada.add(7,this.lectura.lecturaDatos());
		System.out.print("Poblacion: ");
		datosEntrada.add(8,this.lectura.lecturaDatos());
		System.out.print("Porvincia: ");
		datosEntrada.add(9,this.lectura.lecturaDatos());
		System.out.print("C�digo postal: ");
		datosEntrada.add(10,this.lectura.lecturaDatos());
		System.out.print("Tarifa: ");
		datosEntrada.add(11,this.lectura.lecturaDatos());
		if(tipo.equals("P"))
		{
			datosEntrada.add(12,apellido);			
		}
		System.out.println("");
		
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
	@Override
	public ArrayList<Calendar> buscarClientesPorFechaAlta() {
		try{
			ArrayList<Calendar> filtro = new ArrayList<Calendar>();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy"); 
			
			System.out.println("Introduzca la fecha de inicio (ejemplo: 12/4/2015): ");
			System.out.print("--> ");
			Date fecha1 = sdf.parse(lectura.lecturaDatos() , new ParsePosition(0));
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(fecha1);
			filtro.add(cal1);
			
			System.out.println("Introduzca la fecha de fin (ejemplo: 12/4/2015): ");
			System.out.print("--> ");
			Date fecha2 = sdf.parse(lectura.lecturaDatos() , new ParsePosition(0));
			Calendar cal2 = new GregorianCalendar();
			cal1.setTime(fecha2);
			filtro.add(cal2);
			
			return filtro;
		}catch(NullPointerException e)
		{
			System.out.println("java.lang.NullPointerException");
			System.out.println("Error en el formato de la fecha");
			return null;
		}
	}

}
