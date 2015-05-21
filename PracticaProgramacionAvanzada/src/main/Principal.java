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
