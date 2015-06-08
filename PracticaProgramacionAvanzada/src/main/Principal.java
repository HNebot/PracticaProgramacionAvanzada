package main;

import controlador.Controlador;
import gestores.GestorManager;
import interfaces.IntIOInterface;
import interfaces.IntModeloGestor;
import interfaces.IntSalidaInfo;
import salida.SalidaInfoConsola;
import vista.IOInterfazGrafica;
import vista.IOInterfazSalidaConsola;


public class Principal 
{
	/**
	 * El programa tiene la peculiaridad de que se puede elegr la opcion de salida de datos "consola" o interfaz grafica
	 * cambiando entre las dos lineas de codigo:
	 * IntIOInterface IoInterface = new IOInterfazSalidaConsola();
	 * IntIOInterface IoInterface = new IOInterfazGrafica();
	 * @param args
	 */
	
	public static void main(String[] args)
	{	

		Controlador controlador = new Controlador();
		//IntIOInterface IoInterface = new IOInterfazSalidaConsola();
		IntIOInterface IoInterface = new IOInterfazGrafica();
		IntModeloGestor gestorManager = new GestorManager();
		
		controlador.setInterface(IoInterface);
		controlador.setModeloGestor(gestorManager);
		IoInterface.setControlador(controlador);
		
		IntSalidaInfo salidaInfo = new SalidaInfoConsola();
		controlador.setSalida(salidaInfo);
		try {
				IoInterface.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
