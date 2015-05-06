package main;

import controlador.Controlador;
import interfaces.IntIOInterface;
import interfaces.IntLectura;
import interfaces.IntSalidaInfo;
import excepciones.ExcepcionClienteNoEncontrado;
import lectura.LecturaDatosConsola;
import salida.SalidaInfoConsola;
import vista.IOInterfazGrafica;
import vista.IOInterfazSalidaConsola;


public class Principal 
{
	
	public static void main(String[] args)
	{	

		Controlador controlador = new Controlador();
		//IntIOInterface IoInterface = new IOInterfazSalidaConsola();
		IntIOInterface IoInterface = new IOInterfazGrafica();
		controlador.SetInterface(IoInterface);
		IoInterface.setControlador(controlador);
		IntLectura lecturaDatos = new LecturaDatosConsola();
		controlador.setLectura(lecturaDatos);
		IntSalidaInfo salidaInfo = new SalidaInfoConsola();
		controlador.setSalida(salidaInfo);
		try {
				IoInterface.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
