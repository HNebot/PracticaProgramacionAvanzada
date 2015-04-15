package main;

import interfaces.IntIOInterface;
import interfaces.IntLectura;
import interfaces.IntSalidaInfo;
import excepciones.ExcepcionClienteNoEncontrado;
import lectura.LecturaDatosConsola;
import salida.SalidaInfoConsola;


public class Principal 
{
	
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
