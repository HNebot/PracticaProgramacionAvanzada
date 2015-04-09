package menus;

import interfaces.IntMenuLlamadas;

import java.util.ArrayList;
import java.util.Scanner;

import objetos.Llamada;
import lectura.LecturaDatosConsola;

public class OperacionesLlamadasConsola implements IntMenuLlamadas
{
	private Scanner scanner;
	private LecturaDatosConsola lectura;
	
	public OperacionesLlamadasConsola(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public OperacionesLlamadasConsola() {
		this.lectura = new LecturaDatosConsola();
	}

	@Override
	public ArrayList<String> realizarLLamada() {
		ArrayList<String> datos = new ArrayList<String>();
		System.out.println("Introduzca el condigo del cliente que realiza la llamada:");
		datos.add(lectura.lecturaDatos());
		System.out.println("Introduzca el numero de telefono alq ue se llama:");
		datos.add(lectura.lecturaDatos());
		System.out.println("Introduzca la duracion la llamada:");
		datos.add(lectura.lecturaDatos());
		return datos;
	}

	@Override
	public String llamadasCliente() {
		System.out.println("Introduzca el nif del cliente: ");
		return this.lectura.lecturaDatos();
	}

	@Override
	public String mostrarLlamadas(ArrayList<Llamada> llamadas) {
		String informacion = "====================";
		if(llamadas == null) return "El cliente no existe o no tiene llamadas";
		
		for(Llamada llamada: llamadas)
		{
			informacion = informacion + this.formatoLlamadaPantalla(llamada);
			informacion = informacion + "====================";
		}
		return informacion;
	}

	@Override
	public String formatoLlamadaPantalla(Llamada llamada) {
		String infoLlamada = "";
		infoLlamada = infoLlamada + "Telefono receptor: " + llamada.toArray().get(0) + "\n";
		infoLlamada = infoLlamada + "Fecha de la llamada: " + llamada.toArray().get(1) + "\n";
		infoLlamada = infoLlamada + "Duracion de la llamada: " + llamada.toArray().get(2) + "\n";
		return infoLlamada;
	}

}
