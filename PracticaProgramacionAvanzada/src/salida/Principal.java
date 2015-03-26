package salida;

import interfaces.IntIOInterface;

import java.util.ArrayList;

import objetos.Particular;
import gestores.GestorCliente;

public class Principal 
{
	public static GestorCliente gestor = new GestorCliente();
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
		
		Controlador controlador = new Controlador();
		IntIOInterface IoInterface = new IOInterfazSalidaConsola();
		controlador.SetInterface(IoInterface);
		controlador.start();
		
	
		
	}
	

}
