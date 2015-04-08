package main;

import interfaces.IntIOInterface;
import interfaces.IntLectura;
import interfaces.IntSalidaInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import lectura.LecturaDatosConsola;
import objetos.Particular;
import salida.SalidaInfoConsola;

public class Principal 
{
	//public static GestorCliente gestor = new GestorCliente();
	public static void main(String[] args)
	{
		/*ArrayList<String> datos = new ArrayList();
		datos.add("P");
		datos.add("123S");
		datos.add("Hector");
		//datos.add("Nebot");
		datos.add("n@gmail.com");
		datos.add("Avd Pio XII");
		datos.add("17");
		datos.add("2D");
		datos.add("Vila-real");
		datos.add("Castellon");
		datos.add("12540");
		datos.add("0.03");
		datos.add("Nebot");
		
		System.out.println(gestor.altaCliente(datos));
		Particular particular = (Particular) gestor.datosCliente(datos.get(1));
		System.out.println(particular);
		System.out.println(gestor.datosCliente(datos.get(1)).getClass().getSimpleName());*/
		/**
		 * Usamos un cotrolador para gestionar la interaccion entre el modelo y las vistas
		 * Le pasamos un interfaz que sera la que gestione las vistas
		 */
		
		/*Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		System.out.println(sdf.format(cal.getTime()));*/
		
		Controlador controlador = new Controlador();
		IntIOInterface IoInterface = new IOInterfazSalidaConsola();
		controlador.SetInterface(IoInterface);
		IntLectura lecturaDatos = new LecturaDatosConsola();
		controlador.setLectura(lecturaDatos);
		IntSalidaInfo salidaInfo = new SalidaInfoConsola();
		controlador.setSalida(salidaInfo);
		controlador.start();
	}
	

}
