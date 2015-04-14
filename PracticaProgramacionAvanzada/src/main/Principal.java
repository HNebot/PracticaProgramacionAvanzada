package main;

import interfaces.IntIOInterface;
import interfaces.IntLectura;
import interfaces.IntSalidaInfo;

import java.util.Calendar;

import javafx.util.Pair;
import excepciones.ExcepcionClienteNoEncontrado;
import lectura.LecturaDatosConsola;
import salida.SalidaInfoConsola;

public class Principal 
{
	
	public static Pair<String, java.lang.Integer> devolverTupla(String cadena, Integer dato){
		return new Pair<String, Integer>(cadena, dato);
	}
	public static void main(String[] args)
	{		
		
		Pair<String, Integer> tupla = devolverTupla("hola", 3); 
		/*Controlador controlador = new Controlador();
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
		}*/
	}
	

}
