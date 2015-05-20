package operaciones;

import interfaces.IntOperacionesLlamadas;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import controlador.Controlador;
import excepciones.ExcepcionLlamadaNoEncontrada;
import objetos.Llamada;
import lectura.LecturaDatosConsola;
import menus.MenuLlamadasConsola;

public class OperacionesLlamadasConsola implements IntOperacionesLlamadas
{
	
	private Controlador controlador;
	private LecturaDatosConsola lectura;
	
	public OperacionesLlamadasConsola() {
		this.lectura = new LecturaDatosConsola();
	}
	

	@Override
	public void menuPincipalLLamadas() {
		System.out.println(MenuLlamadasConsola.getMenu());
		this.controlador.ejecutaOpcionMenuLlamadas(MenuLlamadasConsola.getOpcion(this.lectura.lecturaEnteros()));
		
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}

	@Override
	public ArrayList<String> realizarLLamada() {
		ArrayList<String> datos = new ArrayList<String>();
		System.out.println("Introduzca el condigo del cliente que realiza la llamada:");
		datos.add(lectura.lecturaDatos());
		System.out.println("Introduzca el numero de telefono al que se llama:");
		datos.add(lectura.lecturaDatos());
		System.out.println("Introduzca la duracion la llamada:");
		datos.add(lectura.lecturaDatos());
		return datos;
	}

	@Override
	public String llamadasCliente() {
		System.out.println("Introduzca el nif del cliente: ");
		String str = this.lectura.lecturaDatos();
		System.out.println(str);
		return str;
	}

	@Override
	public void mostrarLlamadas(ArrayList<Llamada> llamadas) throws ExcepcionLlamadaNoEncontrada {
		String informacion = "====================\n";
		if(llamadas == null) throw new ExcepcionLlamadaNoEncontrada();
		
		for(Llamada llamada: llamadas)
		{
			informacion = informacion + this.formatoLlamadaPantalla(llamada);
			informacion = informacion + "====================\n";
		}
		System.out.println(informacion);
	}

	@Override
	public String formatoLlamadaPantalla(Llamada llamada) {
		String infoLlamada = "";
		infoLlamada = infoLlamada + "Telefono receptor: " + llamada.toArray().get(0) + "\n";
		infoLlamada = infoLlamada + "Fecha de la llamada: " + llamada.toArray().get(1) + "\n";
		infoLlamada = infoLlamada + "Duracion de la llamada: " + llamada.toArray().get(2) + "\n";
		return infoLlamada;
	}

	@Override
	public ArrayList<Calendar> buscarLlamadasClientePorFecha() {
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
		}catch(NullPointerException e){
			System.out.println("java.lang.NullPointerException");
			System.out.println("Error en el formato de la fecha");
			return null;
		}
	}


	@Override
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}


}
