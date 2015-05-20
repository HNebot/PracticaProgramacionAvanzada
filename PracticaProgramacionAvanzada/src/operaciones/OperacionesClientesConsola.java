package operaciones;

import interfaces.IntOperacionesClientes;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import controlador.Controlador;
import javafx.util.Pair;
import enumeraciones.TipoCliente;
import enumeraciones.TipoTarifaFinDeSemana;
import enumeraciones.TipoTarifaHoraria;
import lectura.LecturaDatosConsola;
import menus.MenuClientesConsola;
import objetos.Cliente;

/**
 * @author Hector
 * Esta clase es la que gestiona las salidas por pantalla, en este por consola de la informacion de los clientes
 * 
 * Implementa una interfaz IntMenuClientes que a su vez extiende una de tipo Menu
 */
public class OperacionesClientesConsola implements IntOperacionesClientes
{
	private TipoCliente tipocliente;
	private LecturaDatosConsola lectura;
	private Controlador controlador;
	
	/**
	 * Contructor principal de la clase
	 * Instanciamos un objeto de tipo lectura para leer datos por consola
	 */	public OperacionesClientesConsola() {
		this.lectura = new LecturaDatosConsola();
	}
	
	 
	 @Override
		public void menuPincipalClientes() {
		 System.out.println(MenuClientesConsola.getMenu());
		 this.controlador.ejecutaOpcionMenuCliente(MenuClientesConsola.getOpcion(this.lectura.lecturaEnteros()));
			
		}
	
	/**
	 * Muestra y recoje los datos necesarios para introducir un nuevo cliente
	 * 
	 * Retorna una tupla con El tipo de cliente y los datos en un arrayList de string
	 */
	@Override
	public Pair<TipoCliente, ArrayList<String>> menuNuevoCliente()
	{
		ArrayList<String> datosEntrada = new ArrayList<String>(14);
		String tipo;
		do{
			try{
				System.out.println("Cliente particulas o empresa?");
				System.out.println(TipoCliente.getMenu());
				tipo = this.lectura.lecturaDatos();
				tipocliente = TipoCliente.getOpcion(Integer.parseInt(tipo));
			}catch(Exception e)
			{
				System.out.println("Opcion Incorrecta");
			}
		}
		while(tipocliente == null);
		
		System.out.print("Nombre: ");
		datosEntrada.add(0,this.lectura.lecturaDatos());
		String apellido ="";
		
		if(tipocliente.equals(TipoCliente.PARTICULR))
		{
			System.out.print("Apellido: ");
			apellido = this.lectura.lecturaDatos();
		}
		
		System.out.print("NIF: ");
		datosEntrada.add(1,this.lectura.lecturaDatos());
		System.out.print("email: ");
		datosEntrada.add(2,this.lectura.lecturaDatos());
		System.out.print("telefono: ");
		datosEntrada.add(3,this.lectura.lecturaDatos());
		System.out.print("Calle: ");
		datosEntrada.add(4,this.lectura.lecturaDatos());
		System.out.print("Portal: ");
		datosEntrada.add(5,this.lectura.lecturaDatos());
		System.out.print("Piso y portal: ");
		datosEntrada.add(6,this.lectura.lecturaDatos());
		System.out.print("Poblacion: ");
		datosEntrada.add(7,this.lectura.lecturaDatos());
		System.out.print("Porvincia: ");
		datosEntrada.add(8,this.lectura.lecturaDatos());
		System.out.print("C�digo postal: ");
		datosEntrada.add(9,this.lectura.lecturaDatos());
		if(tipocliente.equals(TipoCliente.PARTICULR))
		{
			datosEntrada.add(10,apellido);			
		}
		System.out.println("");
		
		return new Pair<TipoCliente, ArrayList<String>>(tipocliente, datosEntrada);
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
			info = info + " " + informacion.get(7);
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
			cal2.setTime(fecha2);
			filtro.add(cal2);
			
			return filtro;
		}catch(NullPointerException e)
		{
			System.out.println("java.lang.NullPointerException");
			System.out.println("Error en el formato de la fecha");
			return null;
		}
	}


	@Override
	public TipoTarifaHoraria menuTarifaHoraria() {
		int pos;
		String opcion;
		TipoTarifaHoraria tipoTarifa = null;
		do{
			try{
				pos = -1;
				System.out.println("Elija un tipo de tarifa horaria:");
				System.out.println(TipoTarifaHoraria.getMenu());
				opcion = this.lectura.lecturaDatos();
				pos = Integer.parseInt(opcion);
				tipoTarifa= TipoTarifaHoraria.getOpcion(pos);
			}catch(Exception e)
			{
				//e.printStackTrace();
				System.out.println("Opcion Incorrecta");
			}
		}
		while(tipoTarifa == null);
		return tipoTarifa;
	}


	@Override
	public TipoTarifaFinDeSemana menuTarifaFInDeSemana() {
		int pos;
		String opcion;
		TipoTarifaFinDeSemana tipoTarifa = null;
		do{
			try{
				pos = -1;
				System.out.println("Elija un tipo de tarifa para el fin de semana:");
				System.out.println(TipoTarifaFinDeSemana.getMenu());
				opcion = this.lectura.lecturaDatos();
				pos = Integer.parseInt(opcion);
				tipoTarifa= TipoTarifaFinDeSemana.getOpcion(pos);
			}catch(Exception e)
			{
				System.out.println("Opcion Incorrecta");
			}
		}
		while(tipoTarifa == null);
		return tipoTarifa;
	}


	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}

}
