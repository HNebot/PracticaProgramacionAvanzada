package main;

import interfaces.IntIOInterface;
import interfaces.IntLectura;
import interfaces.IntSalidaInfo;
import java.util.Calendar;
import excepciones.ExcepcionClienteNoEncontrado;
import lectura.LecturaDatosConsola;
import salida.SalidaInfoConsola;

public class Principal 
{
	//public static GestorCliente gestor = new GestorCliente();
	
	static Calendar generar(Calendar fechaInicio)
	{
		Calendar cal = (Calendar) fechaInicio.clone();
		cal.add(Calendar.MONTH, 1);
		return cal;
	}
	public static void main(String[] args)
	{		
		Controlador controlador = new Controlador();
		IntIOInterface IoInterface = new IOInterfazSalidaConsola();
		controlador.SetInterface(IoInterface);
		IntLectura lecturaDatos = new LecturaDatosConsola();
		controlador.setLectura(lecturaDatos);
		IntSalidaInfo salidaInfo = new SalidaInfoConsola();
		controlador.setSalida(salidaInfo);
		try {
			controlador.start();
		} catch (ExcepcionClienteNoEncontrado e) {
			e.printStackTrace();
		}
	}
	

}
